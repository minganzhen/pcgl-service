package cn.gov.chinatax.gt4.swrdsm.core.filter;

import cn.gov.chinatax.gt4.swrdsm.core.mp.page.PaginationContext;
import cn.hutool.core.util.StrUtil;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static cn.gov.chinatax.gt4.swrdsm.util.constant.FilterIgnoreUrl.BIZ_RESOURCES_EXPORT;
import static cn.gov.chinatax.gt4.swrdsm.util.constant.FilterIgnoreUrl.BIZ_RESOURCES_IMPORT;


/**
 * @Copyright：Copyright (c) 2002-2023 Digitalchina CO.,LTD.  All rights reserved.
 * @Company：神州数码信息系统集成服务有限公司
 * @Department：税务地方大客户.CA
 * @Author：huax
 * @CreationTime：2023-03-04 10:41:00
 * @Version：1.0
 * @Compiler：1.8
 * @Description：请求中获取分页参数pageNo和pageSize
 */
@AllArgsConstructor
@Slf4j
public class PageFilter extends OncePerRequestFilter {
    // 默认页码
    public static final Integer DEFAULT_PAGE_NO = 1;
    // 默认每页大小（-1为不分页）
    public static final int DEFAULT_PAGE_SIZE = -1;
    // 默认页总大小
    public static final int MAX_PAGE_SIZE = 1000;
    // 页码
    public static final String PAGE_PARAM_NAME = "PageNumber";
    // 每页大小
    public static final String SIZE_PARAM_NAME = "PageSize";

    private final String apiPrefix; // keypoint 只能拦截该路径 ，tsf的所有监控放行
    @Override
    protected void doFilterInternal(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, FilterChain filterChain) throws ServletException, IOException {
        HttpServletRequest httpRequest = (HttpServletRequest) httpServletRequest;
        PaginationContext.setPageNo(getPageNo(httpRequest));
        PaginationContext.setPageSize(getPageSize(httpRequest));
        try {
            filterChain.doFilter(httpServletRequest, httpServletResponse);
        }
        // 使用完Threadlocal，将其删除。使用finally确保一定将其删除
        finally {
            PaginationContext.removePageNo();
            PaginationContext.removePageSize();
        }
    }


    @Override
    protected boolean shouldNotFilter(HttpServletRequest request) {
        // 如果关闭，则不过滤
        String uri = request.getRequestURI();
        if (!uri.startsWith(apiPrefix)) return true;
        return false;
    }

    /**
     * 获得分页参数的值
     */
    protected Integer getPageNo(HttpServletRequest request) {
        // keypoint 新增如果请求安参数中包含了 export 不进行分页
        String uri = request.getRequestURI();
        // keypoint 在缓存拦截器这里添加一个导出拦截动作
        if (StrUtil.isNotBlank(uri) && (uri.contains(BIZ_RESOURCES_EXPORT) || uri.contains(BIZ_RESOURCES_IMPORT)))
            return null;
        Integer pageNo = getInteger(request, PAGE_PARAM_NAME);
        return pageNo == null || pageNo < DEFAULT_PAGE_NO ? DEFAULT_PAGE_NO : pageNo;
    }

    private Integer getInteger(HttpServletRequest request, String pageParamName) {
        Integer pageNo = null;
        try {
            String pageNos = request.getParameter(pageParamName);
            // keypoint post里面取数据 goff编码问题不支持
//            if (StrUtil.isBlank(pageNos)) {
//                try {
//                    JSONObject object = ServletUtils.getRequestPostJSONObject(request);
//                    pageNos = Optional.ofNullable(object.getString(pageParamName)).orElseGet(() -> null);
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
//            }
            if (StringUtils.isNumeric(pageNos)) {
                pageNo = Integer.parseInt(pageNos);
            }
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
        return pageNo;
    }

    /**
     * 设置默认每页大小
     */
    protected Integer getPageSize(HttpServletRequest request) {
        Integer pageSize = getInteger(request, SIZE_PARAM_NAME);
        return pageSize == null || pageSize <= 0 ? DEFAULT_PAGE_SIZE : pageSize;
    }

}

