package cn.gov.chinatax.gt4.swrdsm.pojo.dto.zdycx;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @Copyright：Copyright (c) 2002-2023 Digitalchina CO.,LTD.  All rights reserved.
 * @Company：神州数码信息系统集成服务有限公司
 * @Department：税务地方大客户.CA
 * @Author：huax
 * @CreationTime：2023-11-23 19:30:00
 * @Version：1.0
 * @Compiler：1.8
 * @Description：ZdycxMxcxDto 自定义查询统计分析字段
 */
@Data
public class ZdycxTjfxDto extends ZdycxMxcxDto {

    @ApiModelProperty(value = "统计分析分组字段")
    private String tjfxGroupBySql;

    @ApiModelProperty(value = "统计分析查询字段")
    private String tjfxSelectSql;
}
