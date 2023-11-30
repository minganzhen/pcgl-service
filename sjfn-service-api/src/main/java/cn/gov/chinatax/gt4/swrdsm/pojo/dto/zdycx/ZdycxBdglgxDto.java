package cn.gov.chinatax.gt4.swrdsm.pojo.dto.zdycx;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import lombok.Data;


@Data
@ApiModel(value = "自定义表单关联关系")
public class ZdycxBdglgxDto implements Serializable {
    /**
     * 表单1（左）
     */
    @ApiModelProperty(value = "表单1（左）")
    private String bdDm1;

    /**
     * 表单2（右）
     */
    @ApiModelProperty(value = "表单2（右）")
    private String bdDm2;

    /**
     * 关联条件展示、不加别名（DJHX=DJXH）
     */
    @ApiModelProperty(value = "关联条件展示、不加别名（DJHX=DJXH）")
    private String gltjmc;

    /**
     * 关联表单代码1
     */
    @ApiModelProperty(value = "关联表单代码1")
    private String glzdDm1;

    /**
     * 关联表单代码2
     */
    @ApiModelProperty(value = "关联表单代码2")
    private String glzdDm2;

    /**
     * id 数开生成
     */
    @ApiModelProperty(value = "id 数开生成")
    private String id;
}