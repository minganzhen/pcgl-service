package cn.gov.chinatax.gt4.swrdsm.pojo.dto.szfn;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * 慧办，慧看配置 Dto
 *
 * @author huax
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SzfnHkHbPzDtoV3 implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 事项名称
     */
    @ApiModelProperty("事项名称")
    private String sxmc;


    /**
     * 是否显示慧办
     */
    @ApiModelProperty("是否显示慧办")
    private String sfxshb;

    /**
     * 是否显示慧看
     */
    @ApiModelProperty("是否显示慧看")
    private String sfxshk;
}
