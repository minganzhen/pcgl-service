package cn.gov.chinatax.gt4.swrdsm.pojo.dto.zdycx;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.Objects;


@Data
@ApiModel(value = "自定义查询展示列")
public class ZdycxZslDto implements Comparable<ZdycxZslDto> {

    /**
     * id
     */
    @ApiModelProperty(value = "id")
    private String id;
    /**
     * 表单代码
     */
    @ApiModelProperty(value = "表单代码")
    private String bdDm;

    /**
     * (列的展示)列名key
     */
    @ApiModelProperty(value = "(列的展示)列名key")
    private String lmKey;

    /**
     * (列的展示)列名名称
     */
    @ApiModelProperty(value = "(列的展示)列名名称")
    private String lmmc;

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
     * 列名排序
     */
    @ApiModelProperty(value = "列名排序")
    private Integer lmpx;

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
     * 列名排序
     */
    @ApiModelProperty(value = "排序方式 N(不排序) ,ASC / DESC")
    private String pxfs;

    @JsonIgnore
    @ApiModelProperty(value = "统计分析对比方式 SQ / TQ")
    private String tjfxDb;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ZdycxZslDto)) return false;

        ZdycxZslDto that = (ZdycxZslDto) o;

        if (!Objects.equals(lmKey, that.lmKey)) return false;
        return Objects.equals(lmmc, that.lmmc);
    }

    @Override
    public int hashCode() {
        int result = lmKey != null ? lmKey.hashCode() : 0;
        result = 31 * result + (lmmc != null ? lmmc.hashCode() : 0);
        return result;
    }

    @Override
    public int compareTo(ZdycxZslDto o) {
        return this.getLmpx() -  o.getLmpx();
    }
}