package cn.gov.chinatax.gt4.swrdsm;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableAsync;
//import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.tsf.annotation.EnableTsf;

/**
 * @author admin
 */
@EnableFeignClients(basePackages = {"cn.gov.chinatax.gt4"})
@ComponentScan(basePackages = {"cn.gov.chinatax.gt4.swrdsm","com.tencent.gov"})
@EnableTsf
@EnableAsync
//@EnableTransactionManagement
@SpringBootApplication
@MapperScan("cn.gov.chinatax.gt4.swrdsm.mapper.**")
public class SjfnServiceWebApplication {

    public static void main(String[] args) {
        SpringApplication.run(SjfnServiceWebApplication.class, args);
    }

}