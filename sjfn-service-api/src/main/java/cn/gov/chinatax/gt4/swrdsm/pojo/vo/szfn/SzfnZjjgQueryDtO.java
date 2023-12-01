package cn.gov.chinatax.gt4.swrdsm.pojo.vo.szfn;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;

/**
 * 事项检查结果 Dto
 *
 * @author huax
 */
@Data
public class SzfnZjjgQueryDtO implements Serializable {

    /**
     * 操作员身份ID
     */
    @ApiModelProperty("操作员身份ID")
    @NotNull(message = "操作员身份ID不能为空")
    private String czysfId;
    /**
     * 权限税务机关代码
     */
    @ApiModelProperty("权限税务机关代码")
    @NotNull(message = "权限税务机关代码不能为空")
    private String qxSwjgDm;

    /**
     * 纳税人名称
     */
    @ApiModelProperty("时间起")
    @NotNull(message = "时间起不能为空")
    private Date sjq;

    /**
     * 检查明细
     */
    @ApiModelProperty("时间止")
    @NotNull(message = "时间止不能为空")
    private Date sjz;
}
