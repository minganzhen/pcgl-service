package cn.gov.chinatax.gt4.swrdsm.pojo.vo.zdycx;

import cn.gov.chinatax.gt4.swrdsm.pojo.dto.zdycx.ZdycxTjXsDto;
import cn.gov.chinatax.gt4.swrdsm.pojo.dto.zdycx.ZdycxZslDto;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotEmpty;
import java.util.List;
import java.util.Map;

/**
 * @Copyright：Copyright (c) 2002-2023 Digitalchina CO.,LTD.  All rights reserved.
 * @Company：神州数码信息系统集成服务有限公司
 * @Department：税务地方大客户.CA
 * @Author：huax
 * @CreationTime：2023-11-22 18:07:00
 * @Version：1.0
 * @Compiler：1.8
 * @Description：ZdycxTjFxBeforeQueryDto 统一分析之前查询动作
 */
@Data
public class ZdycxTjFxBeforeQueryDto {

    @ApiModelProperty(value = "查询条件{key:value}")
    private Map<String, Object> bdKxtjValue;

    @ApiModelProperty(value = "查询条件label{key:value}")
    @NotEmpty(message = "查询条件label不能为空")
    private Map<String, List<ZdycxTjXsDto>> bdKxtjLabel;

    @ApiModelProperty(value = "表单展示列")
    @NotEmpty(message = "表单展示列不能为空")
    private Map<String,List<ZdycxZslDto>> bdZsls;

}
