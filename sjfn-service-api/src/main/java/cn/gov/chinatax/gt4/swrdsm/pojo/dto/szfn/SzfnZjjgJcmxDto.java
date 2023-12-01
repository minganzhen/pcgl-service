package cn.gov.chinatax.gt4.swrdsm.pojo.dto.szfn;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;

/**
 *  检查明细 Dto
 *
 * @author huax
 */
@Data
@AllArgsConstructor
public class SzfnZjjgJcmxDto implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * 事项名称
     */
    @ApiModelProperty("校验错误类型")
    private String jycwlx;


    /**
     * 校验结果
     */
    @ApiModelProperty("校验结果")
    private String tyshxydm;
}
