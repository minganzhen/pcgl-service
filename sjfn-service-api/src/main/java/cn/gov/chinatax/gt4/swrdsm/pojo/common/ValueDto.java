package cn.gov.chinatax.gt4.swrdsm.pojo.common;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * @Copyright：Copyright (c) 2002-2023 Digitalchina CO.,LTD.  All rights reserved.
 * @Company：神州数码信息系统集成服务有限公司
 * @Department：税务地方大客户.CA
 * @Author：huax
 * @CreationTime：2023-11-22 09:49:00
 * @Version：1.0
 * @Compiler：1.8
 * @Description：
 */
@ApiModel(value = "value label")
@Data
public class ValueDto implements Serializable {

    /**
     * 主题代码
     */
    @ApiModelProperty(value = "主题代码")
    private String value;

    /**
     * 主题级次
     */
    @ApiModelProperty(value = "主题级次")
    private String label;
}
