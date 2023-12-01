package cn.gov.chinatax.gt4.swrdsm.pojo.vo.zdycx;

import cn.gov.chinatax.gt4.swrdsm.pojo.dto.zdycx.ZdycxZslDto;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

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
public class ZdycxTjcxQueryDto extends ZdycxMxcxQueryDto {

    @ApiModelProperty(value = "统计分析统计字段和方式")
    private List<ZdycxTjZdfsQueryDto> tjfxJszds;

    @ApiModelProperty(value = "统计分析分组字段")
    private List<ZdycxZslDto> tjfxFzzds;

}
