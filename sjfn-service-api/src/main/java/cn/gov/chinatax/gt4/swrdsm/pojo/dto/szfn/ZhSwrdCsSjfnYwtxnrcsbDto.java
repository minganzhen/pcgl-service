package cn.gov.chinatax.gt4.swrdsm.pojo.dto.szfn;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

@Data
@ApiModel(value = "")
@NoArgsConstructor
@AllArgsConstructor
public class ZhSwrdCsSjfnYwtxnrcsbDto implements Serializable {
    /**
     * 功能标识
     */
    @ApiModelProperty(value = "功能标识")
    private String gnbs;

    /**
     * 录入日期
     */
    @ApiModelProperty(value = "录入日期")
    private Date llrq;

    /**
     * 录入人身份ID
     */
    @ApiModelProperty(value = "录入人身份ID")
    private String lrrsfid;

    /**
     * 数据产生地区
     */
    @ApiModelProperty(value = "数据产生地区")
    private String sjcsdq;

    /**
     * 数据归属地区
     */
    @ApiModelProperty(value = "数据归属地区")
    private String sjgsdq;

    /**
     * 数据同步时间
     */
    @ApiModelProperty(value = "数据同步时间")
    private Date sjtbSj;

    /**
     * 税务机关代码
     */
    @ApiModelProperty(value = "税务机关代码")
    private String swjgDm;

    /**
     * 提醒标题
     */
    @ApiModelProperty(value = "提醒标题")
    private String txbt;

    /**
     * 提醒内容
     */
    @ApiModelProperty(value = "提醒内容")
    private String txnr;

    /**
     * 修改日期
     */
    @ApiModelProperty(value = "修改日期")
    private Date xgrq;

    /**
     * 修改人身份ID
     */
    @ApiModelProperty(value = "修改人身份ID")
    private String xgrsfid;

    /**
     * 业务渠道代码
     */
    @ApiModelProperty(value = "业务渠道代码")
    private String ywqdDm;

    /**
     * 业务提醒内容参数主键ID
     */
    @ApiModelProperty(value = "业务提醒内容参数主键ID")
    private String ywtxnrcszjuuid;

}