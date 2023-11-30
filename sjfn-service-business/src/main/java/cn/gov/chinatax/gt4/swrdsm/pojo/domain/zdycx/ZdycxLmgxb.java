package cn.gov.chinatax.gt4.swrdsm.pojo.domain.zdycx;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;


/**
 * 
 *
 * @author huax
 * @date 2023-11-22
 */
@Data
@TableName(value = "zdycx_lmgxb")
public class ZdycxLmgxb {
    /**
     * 表单代码
     */
    @TableField(value = "bd_dm")
    private String bdDm;

    /**
     * id 数开生成
     */
    @TableId(value = "id", type = IdType.ASSIGN_ID)
    private String id;

    /**
     * 结果列标志 Y、 N
     */
    @TableField(value = "jglbz")
    private String jglbz;

    /**
     * (条件)列名dm
     */
    @TableField(value = "lm_dm")
    private String lmDm;

    /**
     * (列的展示)列名key
     */
    @TableField(value = "lm_key")
    private String lmKey;

    /**
     * (条件)列名lable
     */
    @TableField(value = "lm_label")
    private String lmLabel;

    /**
     * 列名对齐方式（center 、left、right）
     */
    @TableField(value = "lmdqfs")
    private String lmdqfs;

    /**
     * 列名宽度
     */
    @TableField(value = "lmkd")
    private Integer lmkd;

    /**
     * (列的展示)列名名称
     */
    @TableField(value = "lmmc")
    private String lmmc;

    /**
     * 列名排序
     */
    @TableField(value = "lmpx")
    private Integer lmpx;

    /**
     * 取值代码,开发人员维护
     */
    @TableField(value = "qz_dm")
    private String qzDm;

    /**
     * 统计分析分组标志Y，N
     */
    @TableField(value = "tjfxfzbz")
    private String tjfxfzbz;

    /**
     * 统计分析可选值标志 Y，N
     */
    @TableField(value = "tjfxkxzbz")
    private String tjfxkxzbz;

    /**
     * 条件列标志 ( 0 必选；1、预展示；2、可选 )
     */
    @TableField(value = "tjlbz")
    private String tjlbz;

    /**
     * 条件类型
        rq,日期；
        rqfw，日期范围；
        dr,导入；
        srk，输入框；
        sz，数字金额；
        szfw，数字金额范围；
        xldanx，下来单选；
        xlduox，下来多选；
        xlsduox，树多选';
     */
    @TableField(value = "tjlx")
    private String tjlx;

}