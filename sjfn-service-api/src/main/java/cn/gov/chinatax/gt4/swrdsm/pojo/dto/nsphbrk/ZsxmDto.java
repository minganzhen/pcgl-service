package cn.gov.chinatax.gt4.swrdsm.pojo.dto.nsphbrk;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class ZsxmDto {
    @ApiModelProperty(value = "征收项目代码")
    private String zsxmDm;

    @ApiModelProperty(value = "征收项目名称")
    private String zsxmMc;

    @ApiModelProperty(value = "累计入库金额")
    private BigDecimal ljrkJe;

    @ApiModelProperty(value = "累计退库金额")
    private BigDecimal ljtkJe;

    @ApiModelProperty(value = "累计净入库金额")
    private BigDecimal ljjrkJe;
}
