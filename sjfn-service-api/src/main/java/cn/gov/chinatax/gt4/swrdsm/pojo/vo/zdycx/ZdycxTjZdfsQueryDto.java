package cn.gov.chinatax.gt4.swrdsm.pojo.vo.zdycx;

import cn.gov.chinatax.gt4.swrdsm.pojo.dto.zdycx.ZdycxZslDto;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * @Copyright：Copyright (c) 2002-2023 Digitalchina CO.,LTD.  All rights reserved.
 * @Company：神州数码信息系统集成服务有限公司
 * @Department：税务地方大客户.CA
 * @Author：huax
 * @CreationTime：2023-11-22 18:07:00
 * @Version：1.0
 * @Compiler：1.8
 * @Description：ZdycxMxcxQueryDto 自定义统计分析查询Dto
 */
@Data
public class ZdycxTjZdfsQueryDto {

    @ApiModelProperty(value = "计算方式,和 数量 数量去重  平均值（除以条数写死） 占比 （本笔金额除以总金额写死）")
    private String jsfs;

    @ApiModelProperty(value = "对比方式 同比、环比使用")
    private List<String> dbfs = new ArrayList<>();

    @ApiModelProperty(value = "计算字段")
    private ZdycxZslDto jszd;

}
