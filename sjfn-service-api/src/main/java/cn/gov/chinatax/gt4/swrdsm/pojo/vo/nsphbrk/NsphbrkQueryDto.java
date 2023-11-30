package cn.gov.chinatax.gt4.swrdsm.pojo.vo.nsphbrk;

import com.tencent.gov.goff.common.v2.pojo.bean.QueryParam;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

/**
 * @Author：zhaocn
 */
@Data
@ApiModel("纳税排行榜入库查询DTO")
public class NsphbrkQueryDto extends QueryParam {

    @ApiModelProperty(value = "查询日期")
    @NotBlank(message = "查询日期不能为空")
    private String cxrq;

    @ApiModelProperty(value = "权限税务机关代码")
    @NotBlank(message = "权限税务机关代码不能为空")
    private String qxSwjgDm;

    @ApiModelProperty(value = "排名数量")
    @Min(value = 1,message = "排名数量必须大于0")
    private Integer pmsl;

    @ApiModelProperty(value = "忽略",notes = "不需要传值")
    private String cxrqYear;
    @ApiModelProperty(value = "忽略",notes = "不需要传值")
    private String cxrqYearMonth;

}
