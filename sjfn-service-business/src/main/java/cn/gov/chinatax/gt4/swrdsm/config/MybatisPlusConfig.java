package cn.gov.chinatax.gt4.swrdsm.config;

import cn.gov.chinatax.gt4.swrdsm.core.mp.handle.VerticaPageDialect;
import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * MybatisPlus配置
 *
 * @author admin
 */
@Configuration
public class MybatisPlusConfig {

    /**
     * 分页插件
     */
    @Bean
    public PaginationInterceptor paginationInterceptor() {
        PaginationInterceptor pageInterceptor = new PaginationInterceptor();
        pageInterceptor.setLimit(10000);
        return pageInterceptor;
    }

    @Bean
    public VerticaPageDialect defaultVerticaPageDialect() {
        return new VerticaPageDialect();
    }
}