package cn.gov.chinatax.gt4.swrdsm.pojo.dto.czrz;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
@ApiModel(value = "操作日志Dto")
public class ZhSwrdRzSjfnMkdkczrzbDto implements Serializable {
    /**
     * 标题名称
     */
    @ApiModelProperty(value = "标题名称")
    private String btmc;

    /**
     * 操作时间
     */
    @ApiModelProperty(value = "操作时间")
    private Date czsj;

    /**
     * 功能标识
     */
    @ApiModelProperty(value = "功能标识")
    private String gnbs;

    /**
     * 录入日期
     */
    @ApiModelProperty(value = "录入日期")
    private Date lrrq;

    /**
     * 录入人身份ID
     */
    @ApiModelProperty(value = "录入人身份ID")
    private String lrrsfid;

    /**
     * 模块打开操作参数主键ID
     */
    @ApiModelProperty(value = "模块打开操作参数主键ID")
    private String mkdkczcszjuuid;

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

}