package cn.gov.chinatax.gt4.swrdsm.pojo.common;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

@ApiModel("分页结果")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PageResultApi<T> implements Serializable {

    @ApiModelProperty(value = "数据", required = true)
    @JsonProperty("List")
    private List<T> list;

    @ApiModelProperty(value = "总量", required = true)
    @JsonProperty("Total")
    private Long total;

    @ApiModelProperty(value = "页码", required = true)
    @JsonProperty("PageNumber")
    private Long pageNumber;

    @ApiModelProperty(value = "页数", required = true)
    @JsonProperty("PageSize")
    private Long pageSize;
}
