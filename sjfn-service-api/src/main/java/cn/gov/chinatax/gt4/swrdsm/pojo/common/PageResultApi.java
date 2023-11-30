package cn.gov.chinatax.gt4.swrdsm.pojo.common;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

@ApiModel("分页结果")
@Data
public class PageResultApi<T> implements Serializable {

    @ApiModelProperty(value = "数据", required = true)
    private List<T> List;

    @ApiModelProperty(value = "总量", required = true)
    private Long Total;

    @ApiModelProperty(value = "页码", required = true)
    private Long PageNumber;

    @ApiModelProperty(value = "页数", required = true)
    private Long PageSize;
}
