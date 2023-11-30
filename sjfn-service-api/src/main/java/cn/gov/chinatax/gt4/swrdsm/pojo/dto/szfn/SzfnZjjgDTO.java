package cn.gov.chinatax.gt4.swrdsm.pojo.dto.szfn;

import cn.gov.chinatax.gt4.swrdsm.util.core.KeyValue;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * 智检结果Dto
 *
 * @author huax
 */
@Data
public class SzfnZjjgDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 事项名称
     */
    @ApiModelProperty("事项名称")
    private String sxmc;

    /**
     * 检查时间
     */
    @ApiModelProperty("检查时间")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date jcsj;

    /**
     * 社会统一信用代码
     */
    @ApiModelProperty("社会统一信用代码")
    private String shtyxyDm;

    /**
     * 纳税人名称
     */
    @ApiModelProperty("纳税人名称")
    private String nsrmc;

    /**
     * 具体情形
     */
    @ApiModelProperty("具体情形")
    private List<KeyValue> jtqk;
}
