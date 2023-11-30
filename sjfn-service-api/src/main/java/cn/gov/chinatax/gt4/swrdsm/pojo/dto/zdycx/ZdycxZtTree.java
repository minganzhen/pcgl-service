package cn.gov.chinatax.gt4.swrdsm.pojo.dto.zdycx;

import cn.gov.chinatax.gt4.swrdsm.pojo.common.ValueDto;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

@Data
@ApiModel(value = "自定义主题树")
public class ZdycxZtTree extends ValueDto {
    /**
     * 上级主题代码
     */
    @ApiModelProperty(value = "上级主题代码")
    private String pDm;


    /**
     * 主题名称
     */
    @ApiModelProperty(value = "表名视图")
    private String bmst;
}