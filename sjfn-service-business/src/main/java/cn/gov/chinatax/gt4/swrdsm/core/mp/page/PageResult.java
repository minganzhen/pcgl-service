package cn.gov.chinatax.gt4.swrdsm.core.mp.page;

import cn.gov.chinatax.gt4.swrdsm.pojo.common.PageResultApi;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

@ApiModel("分页结果")
@Data
public class PageResult<T> implements Serializable {

    @ApiModelProperty(value = "数据", required = true)
    private List<T> List;

    @ApiModelProperty(value = "总量", required = true)
    private Long Total;

    @ApiModelProperty(value = "页码", required = true)
    private Long PageNumber;

    @ApiModelProperty(value = "页数", required = true)
    private Long PageSize;

    @Deprecated
    public PageResult(List<T> list, Long total) {
        this.List = list;
        this.Total = total;
    }

    @Deprecated
    public PageResult(List<T> list, Long total, Long pageNo, Long pageSize) {
        this.List = list;
        this.Total = total;
        this.PageNumber = pageNo;
        this.PageSize = pageSize;
    }

    @Deprecated
    public PageResult(List<T> list) {
        // 支持page
        if (list instanceof Page) {
            Page<T> page = (Page<T>) list;
            this.Total = page.getTotal();
            this.PageNumber = page.getCurrent();
            this.PageSize = page.getSize();
            this.List = page.getRecords();
        } else {
            this.List = list;
        }
    }
    public PageResult(PageResultApi<T> page) {
        // 支持page
        this.Total = page.getTotal();
        this.PageNumber = page.getPageNumber();
        this.PageSize = page.getPageSize();
        this.List = page.getList();
    }

    /**
     * myabis_plus 原生分页使用
     * @param page
     */
    public PageResult(Page page) {
        // 支持page
        this.Total = page.getTotal();
        this.PageNumber = page.getCurrent();
        this.PageSize = page.getSize();
        this.List = page.getRecords();
    }

    /**
     * 分页构造
     * @param page
     * @return
     */
    public static PageResult build(Page page){
       return new PageResult(page);
    }
}
