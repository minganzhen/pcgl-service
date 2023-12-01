package cn.gov.chinatax.gt4.swrdsm.pojo.dto.zdycx;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.List;


@Data
@ApiModel(value = "自定义查询列名查询条件")
public class ZdycxLmgxbQueryDto implements Serializable {
    /**
     * 表单代码
     */
    @ApiModelProperty(value = "表单代码")
    @NotNull(message = "表单代码不能为空")
    private List<String> bdDms;

    /**
     * 结果列标志 Y、 N
     */
    @ApiModelProperty(value = "结果列标志 Y、 N")
    private String jglbz;

    /**
     * 统计分析分组标志Y，N
     */
    @ApiModelProperty(value = "统计分析分组标志Y，N")
    private String tjfxfzbz;

    /**
     * 统计分析可选值标志 Y，N
     */
    @ApiModelProperty(value = "统计分析可选值标志 Y，N")
    private String tjfxkxzbz;

    /**
     * 条件列标志 ( 0 必选；1、预展示；2、可选 )
     */
    @ApiModelProperty(value = "条件列标志 ( 0 必选；1、预展示；2、可选 )")
    private List<String> tjlbzs;
}