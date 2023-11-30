package cn.gov.chinatax.gt4.swrdsm.pojo.dto.szfn;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * 易查业务信息
 *
 * @author huax
 */
@Data
@ApiModel(value = "易查业务信息")
public class SzfnYcYwxxDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 近三个自然年度收入总额
     */
    @ApiModelProperty("近三个自然年度收入总额")
    private BigDecimal j3gzrndsrze;

    /**
     * 近三个自然年度税款净入库总额
     */
    @ApiModelProperty("近三个自然年度税款净入库总额")
    private BigDecimal j3gzrndskjrkze;

    /**
     * 近三个自然年度综合税负率
     */
    @ApiModelProperty("近三个自然年度综合税负率")
    private String j3gzrndzhsfl;

    /**
     * 近三个自然年度增值税净入库金额
     */
    @ApiModelProperty("近三个自然年度增值税净入库金额")
    private BigDecimal j3gzrndzzsjrkje;

    /**
     * 近三个自然年度企业所得税净入库金额
     */
    @ApiModelProperty("近三个自然年度企业所得税净入库金额")
    private BigDecimal j3gzrndqysdsjrkje;
    /**
     * 近三个自然年度房产税净入库金额
     */
    @ApiModelProperty("近三个自然年度房产税净入库金额")
    private BigDecimal j3gzrndfcsjrkje;
    /**
     * 近三个自然年度城镇土地使用税净入库金额
     */
    @ApiModelProperty("近三个自然年度城镇土地使用税净入库金额")
    private BigDecimal j3gzrndcztdsysjrkje;
    /**
     * 近三个自然年度土地增值税净入库金额
     */
    @ApiModelProperty("近三个自然年度土地增值税净入库金额")
    private BigDecimal j3gzrndtdzzsjrkje;
    /**
     * 近三个自然年度印花税净入库金额
     */
    @ApiModelProperty("近三个自然年度印花税净入库金额")
    private BigDecimal j3gzrndyhsjrkje;
}
