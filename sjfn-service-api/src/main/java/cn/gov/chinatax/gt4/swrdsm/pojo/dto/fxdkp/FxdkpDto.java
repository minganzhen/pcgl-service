package cn.gov.chinatax.gt4.swrdsm.pojo.dto.fxdkp;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;


/**
 * 
 *
 * @author zhaocn
 * @date 2023-11-22
 */
@Data
@ApiModel(value = "风险点卡片DTO")
public class FxdkpDto {
    @ApiModelProperty(value = "核查流程卡片uuid")
    private String hclcKpUuid;

    @ApiModelProperty(value = "接受月份")
    private String jsyf;

    @ApiModelProperty(value = "核查单位")
    private String hcdw;
    private String hsdwmc;

    @ApiModelProperty(value = "疑点总数")
    private Integer ydzs;

    @ApiModelProperty(value = "已核查疑点数")
    private Integer yhcyds;

    @ApiModelProperty(value = "未核查疑点数")
    private Integer whcyds;

    @ApiModelProperty(value = "有效标志")
    private String yxbz;

}