package cn.gov.chinatax.gt4.swrdsm.annotation;

import com.baomidou.dynamic.datasource.annotation.DS;

import java.lang.annotation.*;


/**
 * @Copyright：Copyright (c) 2002-2023 Digitalchina CO.,LTD.  All rights reserved.
 * @Company：神州数码信息系统集成服务有限公司
 * @Department：税务地方大客户.CA
 * @Author：huax
 * @CreationTime：2023-03-01 11:10:00
 * @Version：1.0
 * @Compiler：1.8
 * @Description：汇聚区
 */
@Target({ ElementType.TYPE, ElementType.METHOD })
@Retention(RetentionPolicy.RUNTIME)
@Documented
@DS("hjq")
public @interface HjqDS {


}
