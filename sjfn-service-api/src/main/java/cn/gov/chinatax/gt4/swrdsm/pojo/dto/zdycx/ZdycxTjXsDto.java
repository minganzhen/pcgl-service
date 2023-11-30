package cn.gov.chinatax.gt4.swrdsm.pojo.dto.zdycx;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.Objects;


@Data
@ApiModel(value = "自定义条件显示Dto")
public class ZdycxTjXsDto implements Serializable {

    /**
     * 表单代码
     */
    @ApiModelProperty(value = "表单代码")
    private String bdDm;


    /**
     * (条件)列名dm
     */
    @ApiModelProperty(value = "(条件)列名dm")
    private String lmDm;

    /**
     * (条件)列名lable
     */
    @ApiModelProperty(value = "(条件)列名lable")
    private String lmLabel;


    /**
     * 取值代码,开发人员维护
     */
    @ApiModelProperty(value = "取值代码,开发人员维护")
    private String qzDm;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ZdycxTjXsDto)) return false;

        ZdycxTjXsDto that = (ZdycxTjXsDto) o;

        if (!lmDm.equals(that.lmDm)) return false;
        if (!lmLabel.equals(that.lmLabel)) return false;
        return tjlbz.equals(that.tjlbz);
    }

    @Override
    public int hashCode() {
        int result = lmDm.hashCode();
        result = 31 * result + lmLabel.hashCode();
        result = 31 * result + tjlbz.hashCode();
        return result;
    }
}