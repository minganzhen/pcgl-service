package cn.gov.chinatax.gt4.swrdsm.pojo.dto.szfn;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

@Data
@ApiModel(value = "查询条件")
public class ZhSwrdCsSjfnYwtxnrcsbQueryDto implements Serializable {
    /**
     * 功能标识
     */
    @ApiModelProperty(value = "功能标识")
    private String gnbs;

    /**
     * 提醒标题
     */
    @ApiModelProperty(value = "提醒标题")
    private String txbt;

    /**
     * 业务提醒内容参数主键ID
     */
    @ApiModelProperty(value = "业务提醒内容参数主键ID")
    private String ywtxnrcszjuuid;

}