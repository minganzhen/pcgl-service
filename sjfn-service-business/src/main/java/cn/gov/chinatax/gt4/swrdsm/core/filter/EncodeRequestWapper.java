package cn.gov.chinatax.gt4.swrdsm.core.filter;


import cn.hutool.core.util.ObjectUtil;

import javax.servlet.ReadListener;
import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

/**
 * EncodeRequestWapper
 * @author huax
 */
public class EncodeRequestWapper extends HttpServletRequestWrapper {

    /**
     * 解密之后的byte数据
     */
    private byte[] body;

    private Map<String,String[]> params = new HashMap<>();

    public EncodeRequestWapper(HttpServletRequest request) {
        super(request);
    }

    public EncodeRequestWapper(HttpServletRequest request, String deData) throws IOException {
        super(request);
        this.body = deData.getBytes("utf-8");
    }

    @Override
    public BufferedReader getReader() throws IOException {
        return new BufferedReader(new InputStreamReader(getInputStream()));
    }

    @Override
    public ServletInputStream getInputStream() throws IOException {
        if(ObjectUtil.isEmpty(body)){
           body = new byte[0];
        }
        final ByteArrayInputStream inputStream = new ByteArrayInputStream(body);
        // 返回 ServletInputStream
        return new ServletInputStream() {

            @Override
            public int read() {
                return inputStream.read();
            }

            @Override
            public boolean isFinished() {
                return false;
            }

            @Override
            public boolean isReady() {
                return false;
            }

            @Override
            public void setReadListener(ReadListener readListener) {}

            @Override
            public int available() {
                return body.length;
            }

        };
    }
    @Override
    public String getParameter(String name) {
        String[] values = params.get(name);
        if(values == null || values.length == 0) {
            return null;
        }
        return values[0];
    }

    @Override
    public Enumeration<String> getParameterNames() {
        return Collections.enumeration(params.keySet());
    }

    @Override
    public String[] getParameterValues(String name) {
        return params.get(name);
    }

    @Override
    public Map<String, String[]> getParameterMap() {
        return this.params;
    }

    public void setParameter(Map<String, String> map) {
        params.clear();
        map.forEach((key, value) -> params.put(key, new String[]{value}));
    }
}
