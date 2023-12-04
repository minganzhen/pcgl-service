package cn.gov.chinatax.gt4.swrdsm.core.mp.page;

import cn.gov.chinatax.gt4.swrdsm.pojo.common.PageResultApi;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
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

    @Deprecated
    public PageResult(List<T> list) {
        // 支持page
        if (list instanceof Page) {
            Page<T> page = (Page<T>) list;
            this.total = page.getTotal();
            this.pageNumber = page.getCurrent();
            this.pageSize = page.getSize();
            this.list = page.getRecords();
        } else {
            this.list = list;
        }
    }
    public PageResult(PageResultApi<T> page) {
        // 支持page
        this.total = page.getTotal();
        this.pageNumber = page.getPageNumber();
        this.pageSize = page.getPageSize();
        this.list = page.getList();
    }

    /**
     * myabis_plus 原生分页使用
     * @param page
     */
    public PageResult(Page page) {
        // 支持page
        this.total = page.getTotal();
        this.pageNumber = page.getCurrent();
        this.pageSize = page.getSize();
        this.list = page.getRecords();
    }

    /**
     * 分页构造
     * @param page
     * @return
     */
    public static PageResult build(Page page){
       return new PageResult(page);
    }

    public static PageResultApi buildApi(Page page){
       return new PageResultApi(page.getRecords(),page.getTotal(),page.getCurrent(),page.getSize());
    }
}
