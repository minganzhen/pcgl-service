package cn.gov.chinatax.gt4.swrdsm.pojo.vo.fxdkp;

import cn.gov.chinatax.gt4.swrdsm.pojo.dto.zdycx.ZdycxTjXsDto;
import cn.gov.chinatax.gt4.swrdsm.pojo.dto.zdycx.ZdycxZslDto;
import cn.gov.chinatax.gt4.swrdsm.util.core.KeyValue;
import com.tencent.gov.goff.common.v2.pojo.bean.QueryParam;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.Map;

/**
 * @Author：zhaocn
 */
@Data
@ApiModel("风险点卡片查询DTO")
public class FxdkpQueryDto extends QueryParam {

    @ApiModelProperty(value = "接收月份")
    @NotBlank(message = "接收月份不能为空")
    private String jsyf;

    @ApiModelProperty(value = "接收月份")
    @NotBlank(message = "税务机关代码不能为空")
    private String swjgDm;

}
