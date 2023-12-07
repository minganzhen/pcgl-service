package cn.gov.chinatax.gt4.swrdsm.config.web;

import cn.gov.chinatax.gt4.swrdsm.core.filter.EncryptFilter0;
import cn.gov.chinatax.gt4.swrdsm.core.filter.PageFilter;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.PathMatcher;

import javax.servlet.Filter;

/**
 * FilterConfig过滤器适配
 *
 * @author huax
 */
@Configuration
@RequiredArgsConstructor
@SuppressWarnings("all")
@Slf4j
@EnableConfigurationProperties({EncryProperties.class})
public class FilterConfig {

    @Value("${server.servlet.context-path:/swrdsm-api}")
    private String apiPrefix;
    /**
     * 将加解密过滤器加入过滤链
     *
     * @return 过滤链
     */
    @SuppressWarnings({"rawtypes", "unchecked"})
    @Bean
    @ConditionalOnProperty(value = "chinatax.gt4.encryption.enable", havingValue = "true")
    public FilterRegistrationBean<EncryptFilter0> encryptFilter(EncryProperties properties, PathMatcher pathMatcher) {
        log.info("[过滤器encryptFilter]初始化启动成功");
        log.info("[过滤器encryptFilter] interceptUrls={}", properties.getInterceptUrls());
        return createFilterBean(new EncryptFilter0(properties, pathMatcher, apiPrefix), Integer.MIN_VALUE + 100); // 拦截放到最外面
    }

    /**
     * 创建 pageFilter Bean，拦截分页参数处理
     */
    @SuppressWarnings({"rawtypes", "unchecked"})
    @Bean
    public FilterRegistrationBean<PageFilter> pageFilter(PathMatcher pathMatcher) {
        log.info("[过滤器pageFilter]初始化启动成功");
        return createFilterBean(new PageFilter(apiPrefix), -101);
    }

    private static <T extends Filter> FilterRegistrationBean<T> createFilterBean(T filter, Integer order) {
        FilterRegistrationBean<T> bean = new FilterRegistrationBean<>(filter);
        bean.setOrder(order);
        return bean;
    }
}
