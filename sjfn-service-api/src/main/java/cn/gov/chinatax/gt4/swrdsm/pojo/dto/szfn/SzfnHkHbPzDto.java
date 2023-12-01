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
public class SzfnHkHbPzDto implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 业务大类
     */
    @ApiModelProperty("业务大类")
    private String ywdl;


    /**
     * 小类
     */
    @ApiModelProperty("业务小类")
    private String ywxl;

    /**
     * 业务名称
     */
    @ApiModelProperty("业务名称")
    private String ywmc;

    /**
     * 配置项
     */
    @ApiModelProperty("配置项")
    private String pzx;

    /**
     * 配置项与标题关系
     */
    @ApiModelProperty("配置项与标题关系, contain[包含]、equal[等于]")
    private String pzxYbtGx;
}
