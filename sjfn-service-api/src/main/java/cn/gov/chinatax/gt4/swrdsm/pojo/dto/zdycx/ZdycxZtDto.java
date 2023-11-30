package cn.gov.chinatax.gt4.swrdsm.pojo.dto.zdycx;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

@Data
@ApiModel(value = "自定义主题Dto")
public class ZdycxZtDto implements Serializable {
	/**
	 * 上级主题代码
	 */
    @ApiModelProperty(value = "上级主题代码")
	private String sjDm;

	/**
	 * Y/N
	 */
    @ApiModelProperty(value = "Y/N")
	private String yxbz;

	/**
	 * 主题代码
	 */
    @ApiModelProperty(value = "主题代码")
	private String ztDm;

	/**
	 * 主题级次
	 */
    @ApiModelProperty(value = "主题级次")
	private String ztJc;

	/**
	 * 主题名称
	 */
    @ApiModelProperty(value = "主题名称")
	private String ztmc;
}