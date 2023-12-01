package cn.gov.chinatax.gt4.swrdsm.pojo.dto.zdycx;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;


@Data
@ApiModel(value = "自定义查询列名关系")
public class ZdycxLmgxbDto implements Serializable {
    /**
     * id 数开生成
     */
    @ApiModelProperty(value = "id 数开生成")
    private String id;
    /**
     * 表单代码
     */
    @ApiModelProperty(value = "表单代码")
    private String bdDm;

    /**
     * 结果列标志 Y、 N
     */
    @ApiModelProperty(value = "结果列标志 Y、 N")
    private String jglbz;

    /**
     * (条件)列名dm
     */
    @ApiModelProperty(value = "(条件)列名dm")
    private String lmDm;

    /**
     * (列的展示)列名key
     */
    @ApiModelProperty(value = "(列的展示)列名key")
    private String lmKey;

    /**
     * (条件)列名lable
     */
    @ApiModelProperty(value = "(条件)列名lable")
    private String lmLabel;

    /**
     * 列名对齐方式（center 、left、right）
     */
    @ApiModelProperty(value = "列名对齐方式（center 、left、right）")
    private String lmdqfs;

    /**
     * 列名宽度
     */
    @ApiModelProperty(value = "列名宽度")
    private Integer lmkd;

    /**
     * (列的展示)列名名称
     */
    @ApiModelProperty(value = "(列的展示)列名名称")
    private String lmmc;

    /**
     * 列名排序
     */
    @ApiModelProperty(value = "列名排序")
    private Integer lmpx;

    /**
     * 取值代码,开发人员维护
     */
    @ApiModelProperty(value = "取值代码,开发人员维护")
    private String qzDm;

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
    private String tjlbz;

    /**
     * 条件类型
     * rq,日期；
     * rqfw，日期范围；
     * dr,导入；
     * srk，输入框；
     * sz，数字金额；
     * szfw，数字金额范围；
     * xldanx，下来单选；
     * xlduox，下来多选；
     * xlsduox，树多选';
     */
    @ApiModelProperty(value = "条件类型")
    private String tjlx;

}