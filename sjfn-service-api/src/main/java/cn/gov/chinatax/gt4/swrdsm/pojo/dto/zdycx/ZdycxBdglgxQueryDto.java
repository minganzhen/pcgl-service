package cn.gov.chinatax.gt4.swrdsm.pojo.dto.zdycx;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.io.Serializable;


@Data
@ApiModel(value = "自定义表单关联关系 查询条件")
public class ZdycxBdglgxQueryDto implements Serializable {
    /**
     * 表单1（左）
     */
    @ApiModelProperty(value = "表单1（左）")
    @NotNull(message = "表单1（左）不能为空")
    private String bdDm1;

    /**
     * 表单2（右）
     */
    @ApiModelProperty(value = "表单2（右）")
    @NotNull(message = "表单2（右）不能为空")
    private String bdDm2;
}