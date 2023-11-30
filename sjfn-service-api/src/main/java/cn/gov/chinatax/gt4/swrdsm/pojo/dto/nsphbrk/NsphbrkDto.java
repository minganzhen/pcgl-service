package cn.gov.chinatax.gt4.swrdsm.pojo.dto.nsphbrk;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;


/**
 * @author zhaocn
 * @date 2023-11-22
 */
@Data
@ApiModel(value = "纳税排行榜入库DTO")
public class NsphbrkDto {
    @ApiModelProperty(value = "排名")
    private Integer pm;

    @ApiModelProperty(value = "社会信用代码(纳税人识别号)")
    private String nsrsbh;

    @ApiModelProperty(value = "纳税人名称")
    private String nsrmc;

    @ApiModelProperty(value = "行业")
    private String hyDm;
    private String hyMc;

    @ApiModelProperty(value = "登记注册类型")
    private String djzclxDm;
    private String djzclxMc;

    @ApiModelProperty(value = "税费净入库合计")
    private BigDecimal hjjrkJe;

    @ApiModelProperty(value = "统计时间")
    private String tjsj;

    @ApiModelProperty(value = "分征收项目入库金额列表")
    private List<ZsxmDto> zsxmList;

}