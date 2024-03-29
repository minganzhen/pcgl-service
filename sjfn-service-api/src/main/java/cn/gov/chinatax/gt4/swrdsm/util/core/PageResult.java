package cn.gov.chinatax.gt4.swrdsm.util.core;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

@ApiModel("分页结果")
@Data
public class PageResult<T> implements Serializable {

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

    @Deprecated
    public PageResult(List<T> list, Long total) {
        this.list = list;
        this.total = total;
    }

    @Deprecated
    public PageResult(List<T> list, Long total, Long pageNo, Long pageSize) {
        this.list = list;
        this.total = total;
        this.pageNumber = pageNo;
        this.pageSize = pageSize;
    }

    public PageResult(List<T> list) {
        // 支持page
        if (list instanceof com.github.pagehelper.Page ) {
            com.github.pagehelper.Page <T> page = (com.github.pagehelper.Page <T>) list;
            this.total = page.getTotal();
            this.pageNumber = Long.valueOf(String.valueOf(page.getPageNum()));
            this.pageSize = Long.valueOf(String.valueOf(page.getPageSize()));
            this.list = page;
        } else {
            this.list = list;
        }
    }
    public static<T> PageResult build(List<T> list) {
        return new PageResult(list);
    }


}
