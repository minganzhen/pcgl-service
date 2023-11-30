package cn.gov.chinatax.gt4.swrdsm.pojo.dto.szfn;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * 易查基本信息
 *
 * @author huax
 */
@Data
@ApiModel(value = "易查基本信息")
public class SzfnYcjbxxDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 开业(设立)日期
     */
    @ApiModelProperty("开业(设立)日期")
    private String ksrq;

    /**
     * 纳税信用等级
     */
    @ApiModelProperty("纳税信用等级")
    private String nsxydj;

    /**
     * 一般纳税人认定时间
     */
    @ApiModelProperty("一般纳税人认定时间")
    private String ybnsrrdsj;

    /**
     * 数电票授信类别
     */
    @ApiModelProperty("数电票授信类别")
    private String sdpsxlb;

    /**
     * 数电票授信额度
     */
    @ApiModelProperty("数电票授信额度")
    private BigDecimal sdpsxed;
}
