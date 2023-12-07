package cn.gov.chinatax.gt4.swrdsm.core.mp.page;

import com.github.pagehelper.PageHelper;
import com.tencent.gov.goff.common.v2.pojo.bean.QueryParam;


/**
 * @Copyright：Copyright (c) 2002-2023 Digitalchina CO.,LTD.  All rights reserved.
 * @Company：神州数码信息系统集成服务有限公司
 * @Department：税务地方大客户.CA
 * @Author：huax
 * @CreationTime：2023-03-01 11:10:00
 * @Version：1.0
 * @Compiler：1.8
 * @Description：分页拦截工具
 * alibaba TransmittableThreadLocal 保证在main线程执行结束之后还可以拿到分页参数
 * TransmittableThreadLocal 改造为 ThreadLocal
 */
public class PaginationContext {

    private static ThreadLocal<Integer> pageNo = new ThreadLocal<>();
    private static ThreadLocal<Integer> pageSize = new ThreadLocal<Integer>();

    public static Integer getPageNo() {
        return pageNo.get();
    }

    public static void setPageNo(Integer pageNoValue) {
        pageNo.set(pageNoValue);
    }

    public static void removePageNo() {
        pageNo.remove();
    }

    public static Integer getPageSize() {
        return pageSize.get();
    }

    public static void setPageSize(Integer pageSizeValue) {
        pageSize.set(pageSizeValue);
    }

    public static void removePageSize() {
        pageSize.remove();
    }

    /**
     * @description: 分页设置 目前只能拦截get请求
     * @author: huax
     * @date: 2023/3/1 14:44
     * @param: []
     * @return: void
     **/
    public static void trySetPagable() {
        if (PaginationContext.getPageNo() != null && PaginationContext.getPageSize() != null && PaginationContext.getPageSize() != -1) {
            PageHelper.startPage(PaginationContext.getPageNo(), PaginationContext.getPageSize());
        }
    }
    public static void trySetPagable(Integer pageNumber,Integer pageSize) {
        PageHelper.startPage(pageNumber, pageSize);
    }
    public static void trySetPagable(QueryParam queryParam) {
        PageHelper.startPage(queryParam.getPageNumber(), queryParam.getPageSize());
    }
}

