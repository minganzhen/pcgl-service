package cn.gov.chinatax.gt4.swrdsm.core.filter;

import cn.gov.chinatax.gt4.swrdsm.config.web.EncryProperties;
import cn.gov.chinatax.gt4.swrdsm.core.assertions.AssertUtil;
import cn.gov.chinatax.gt4.swrdsm.core.servlet.ServletUtils;
import cn.gov.chinatax.gt4.swrdsm.util.constant.Constant;
import cn.gov.chinatax.gt4.swrdsm.util.encryption.DecryptManage;
import com.alibaba.fastjson.JSONObject;
import com.tencent.gov.goff.common.v2.core.configuration.ExceptionController;
import com.tencent.gov.goff.common.v2.core.exception.GoffException;
import com.tencent.gov.goff.common.v2.core.util.IDUtils;
import com.tencent.gov.goff.common.v2.core.util.SerializeUtil;
import com.tencent.gov.goff.common.v2.pojo.bean.ServerResponse;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.MDC;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.PathMatcher;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import static cn.gov.chinatax.gt4.swrdsm.util.constant.FilterIgnoreUrl.BIZ_RESOURCES_EXPORT;
import static cn.gov.chinatax.gt4.swrdsm.util.constant.FilterIgnoreUrl.BIZ_RESOURCES_IMPORT;

/**
 * @Copyright：Copyright (c) 2002-2023 Digitalchina CO.,LTD.  All rights reserved.
 * @Company：神州数码信息系统集成服务有限公司
 * @Department：税务地方大客户.CA
 * @Author：huax
 * @CreationTime：2023-03-02 18:30:00
 * @Version：1.0
 * @Compiler：1.8
 * @Description：EncryptFilter 加密过滤器
 */
@AllArgsConstructor
@Slf4j
public class EncryptFilter extends OncePerRequestFilter {

    private final EncryProperties properties;

    private final PathMatcher pathMatcher;

    private final String apiPrefix; // keypoint 只能拦截该路径 ，tsf的所有监控放行

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {

        try {
            DecryptManage decryptManage = new DecryptManage();
            Map<String, String> headerMap = this.getHeaderMap(request);

            if (isSwagger(headerMap)) {
                filterChain.doFilter(request, response);
                return;
            }
            EncodeResponseWapper responseWapper = new EncodeResponseWapper(response);
            // keypoint 适配 get 请求
            if (HttpMethod.GET.name().equalsIgnoreCase(request.getMethod())) {
                EncodeRequestWapper requestWapper = new EncodeRequestWapper(request);
                Map<String, String[]> parameterMap = request.getParameterMap();
                if (parameterMap.size() == 0 && !isSwagger(headerMap)) {
                    filterChain.doFilter(request, responseWapper);
                    checkParam(response, responseWapper);
                    return;
                }
                // keypoint 前端格式 0? json格式加密
                AssertUtil.isTrue(parameterMap.size() > 0, () -> "parameterMap Length less than zero");
                AssertUtil.isNotNull(parameterMap.get("0"), () -> "parameterMap.size() is null");
                AssertUtil.isNotNull(parameterMap.get("0")[0], () -> "parameterMap.get(\"0\")[0] is null ");
                String encryptParam = parameterMap.get("0")[0];
                //log.info("前端传参：{}", encryptParam);
                String param = decryptManage.decryptText(encryptParam);
                //log.info("前端传参解密后：{}", param);
                Map<String, String> map = this.buildParam(param);
                requestWapper.setParameter(map);
                filterChain.doFilter(requestWapper, responseWapper);
            }
            // keypoint 1.适配 POST、PUT、DELETE 请求 规范DELETE请求在加密中只能处理 json形式
            else if (HttpMethod.POST.name().equalsIgnoreCase(request.getMethod())
                    || HttpMethod.PUT.name().equalsIgnoreCase(request.getMethod())
                    || HttpMethod.DELETE.name().equalsIgnoreCase(request.getMethod())) {
                String requestPostStr = ServletUtils.getRequestPostStr(request);
                //log.info("获取前端传参：{}", requestPostStr);
                if (StringUtils.isEmpty(requestPostStr)) {
                    filterChain.doFilter(request, responseWapper);
                    checkParam(response, responseWapper);
                    return;
                }
                JSONObject jsonObject = JSONObject.parseObject(requestPostStr);
                // keypoint {0:json格式}
                String requestParamStr = jsonObject.getString("0");
                String encode = decryptManage.decryptText(requestParamStr);
                //log.info("前端传参解密后：{}", encode);
                EncodeRequestWapper requestWapper = new EncodeRequestWapper(request, encode);
                filterChain.doFilter(requestWapper, responseWapper);
            }
            this.checkParam(response, responseWapper);
        } catch (Throwable ex) {
            /**
             * 改造来自goff源码包 {@link  ExceptionController}
             */
            log.error("cn.gov.chinatax.gt4.swrdsm.core.filter.EncryptFilter 抛出异常{}", ex.getMessage());
            String requestId = MDC.get("X-B3-TraceId") != null ? MDC.get("X-B3-TraceId") : IDUtils.randomUUID();
            ServerResponse<Object> fail = ServerResponse.fail(Constant.CodeStr.FAILURE, ex.getMessage());
            fail.getResponse().setRequestId(requestId);
            SerializeUtil.writeResponse(response, new ResponseEntity(fail, HttpStatus.OK).getBody());
        }

    }

    @Override
    protected boolean shouldNotFilter(HttpServletRequest request) {
        if (!properties.isEnable()) return true;
        String uri = request.getRequestURI();
        if (!uri.startsWith(apiPrefix)) return true;
        if (StringUtils.hasText(uri) && (uri.contains(BIZ_RESOURCES_EXPORT) || uri.contains(BIZ_RESOURCES_IMPORT)))
            return true;
        return properties.getExcludeUrls().stream().anyMatch(excludeUrl -> pathMatcher.match(excludeUrl, uri));
    }

    private void checkParam(ServletResponse response, EncodeResponseWapper responseWapper) throws IOException {
        byte[] responseDataBytes = responseWapper.getResponseData();
        String responseData = new String(responseDataBytes, StandardCharsets.UTF_8);
        DecryptManage decryptManage = new DecryptManage();
        String encryptResponseData = decryptManage.encryptText(responseData);
        PrintWriter writer = response.getWriter();
        writer.print(encryptResponseData);
        writer.flush();
        writer.close();
    }

    private Map<String, String> getHeaderMap(HttpServletRequest request) {
        Map<String, String> headerMap = new HashMap<>();
        Enumeration<String> headerNames = request.getHeaderNames();
        while (headerNames.hasMoreElements()) {
            String name = headerNames.nextElement();
            headerMap.put(name, request.getHeader(name));
        }
        return headerMap;
    }

    private Map<String, String> buildParam(String decryptParam) {
        JSONObject jsonObject = JSONObject.parseObject(decryptParam);
        Map<String, String> map = new HashMap<>();
        Set<Map.Entry<String, Object>> entries = jsonObject.entrySet();
        for (Map.Entry<String, Object> entry : entries) {
            String key = entry.getKey();
            String value = String.valueOf(entry.getValue());
            if (!value.equalsIgnoreCase("null")) {
                value = String.valueOf(entry.getValue());
            } else {
                value = null;
            }
            map.put(key, value);
        }

        return map;
    }

    private Boolean isSwagger(Map<String, String> reqMap) {
        if (reqMap.containsKey("noencry")) {
            return Boolean.parseBoolean(reqMap.get("noencry"));
        }
        return false;
    }
}
