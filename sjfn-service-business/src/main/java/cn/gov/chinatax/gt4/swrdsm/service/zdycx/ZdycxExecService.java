package cn.gov.chinatax.gt4.swrdsm.service.zdycx;

import cn.gov.chinatax.gt4.swrdsm.annotation.HjqDS;
import cn.gov.chinatax.gt4.swrdsm.core.assertions.AssertUtil;
import cn.gov.chinatax.gt4.swrdsm.core.mp.page.PageResult;
import cn.gov.chinatax.gt4.swrdsm.mapper.zdycx.ZdycxExecMapper;
import cn.gov.chinatax.gt4.swrdsm.pojo.dto.zdycx.ZdycxMxcxDto;
import cn.gov.chinatax.gt4.swrdsm.pojo.dto.zdycx.ZdycxTjfxDto;
import cn.gov.chinatax.gt4.swrdsm.pojo.dto.zdycx.ZdycxZslDto;
import cn.gov.chinatax.gt4.swrdsm.pojo.vo.zdycx.ZdycxMxcxQueryDto;
import cn.gov.chinatax.gt4.swrdsm.pojo.vo.zdycx.ZdycxTjcxQueryDto;
import cn.gov.chinatax.gt4.swrdsm.util.constant.Constant;
import cn.gov.chinatax.gt4.swrdsm.util.enums.BdTjfxDbEnum;
import cn.gov.chinatax.gt4.swrdsm.util.enums.BdTjfxJsEnum;
import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.util.ObjectUtil;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.google.common.collect.Lists;
import com.tencent.gov.goff.common.v2.core.exception.GoffException;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.*;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;

import static cn.gov.chinatax.gt4.swrdsm.core.util.SqlExecJoinUtil.*;
import static cn.gov.chinatax.gt4.swrdsm.util.enums.BdTjfxDbEnum.BQ;
import static cn.gov.chinatax.gt4.swrdsm.util.enums.BdTjfxDbEnum.TB;

/**
 * sql 执行器 业务层
 *
 * @author huax
 * @date 2023-11-21
 */
@Service
@HjqDS
public class ZdycxExecService extends ZdycxAbstractExecService {

    @Resource
    private ZdycxExecMapper zdycxExecMapper;
    @Resource(name = "zdycx-mxcx-async-executor")
    private ThreadPoolTaskExecutor mxcxExecutor;
    @Resource(name = "zdycx-tjfx-async-executor")
    private ThreadPoolTaskExecutor tjfxExecutor;
    private static final List<String> mxForList = Lists.newArrayList("tableSql", "whereSql", "orderBySql、selectSql");

    /**
     * 明细查询
     *
     * @param queryDto
     * @return
     */
    @Override
    public Map<String, Object> selectMxcx(ZdycxMxcxQueryDto queryDto) {
        Set<ZdycxZslDto> tableHeadSet = getZdycxZslDtos(queryDto); // 3、构建表头
        List<String> errorMsg = Collections.synchronizedList(new ArrayList<>(4)); // 将ArrayList转换成线程安全
        ZdycxMxcxDto mxcxDto = new ZdycxMxcxDto();
        mxForList.stream().map(item ->
                CompletableFuture.runAsync(() -> {
                    switch (item) {
                        case "tableSql":
                            StringBuilder tableSql = builderTableSql(queryDto, true); // 1、构建 tableSql
                            mxcxDto.setTableSql(tableSql.toString());
                            break;
                        case "whereSql":
                            StringBuilder whereSql = builderWhereSql(queryDto); // 2、构建 whereSql
                            mxcxDto.setWhereSql(whereSql.toString());
                            break;
                        default:
                            StringBuilder orderBySql = builderOrderBySql(tableHeadSet);  // 4、构建 orderBySql
                            StringBuilder selectSql = builderSelectSql(tableHeadSet); // 5、构建 selectSql
                            mxcxDto.setSelectSql(selectSql.toString());
                            mxcxDto.setOrderBySql(orderBySql.toString());
                            break;
                    }
                }, mxcxExecutor).exceptionally(throwable -> {
                    errorMsg.add(String.format("【自定义查询】构建：%s 发生异常，异常信息%s", item, throwable.getMessage()));
                    throw new GoffException(Constant.CodeStr.FAILURE, throwable.getMessage());
                })
        ).map(CompletableFuture::join).collect(Collectors.toList());
        if (ObjectUtil.isNotEmpty(errorMsg)) AssertUtil.isTrue(false, errorMsg.toString()); // 异常信息抛出
        Page<Map> page = new Page<>(queryDto.getPageNumber(), queryDto.getPageSize());
        Page<List<Map<String, Object>>> listPage = zdycxExecMapper.selectMxcx(page, mxcxDto);
        // 返回表头和 maps数据
        Map<String, Object> returnData = new HashMap<>(3);
        returnData.put("tableHead", tableHeadSet);
        returnData.put("tableData", PageResult.build(listPage));
        return returnData;
    }


    /**
     * 统计查询
     *
     * @param queryDto
     * @return
     */
    @Override
    public Map<String, Object> selectTjcx(ZdycxTjcxQueryDto queryDto) {
        Map<String, String> thbMap = new HashMap<>(4); // 处理同环比条件值存储
        ZdycxTjfxDto zdycxTjfxDto = new ZdycxTjfxDto();

        CompletableFuture<Void> future1 = CompletableFuture.runAsync(() -> {
            StringBuilder tableSql = builderTableSql(queryDto, false); // 1、构建 tableSql
            Set<ZdycxZslDto> tableHeadSet = getZdycxZslDtos(queryDto); // 2、sql字段排序处理
            StringBuilder orderBySql = builderOrderBySql(tableHeadSet); // 2、构建 orderBy
            zdycxTjfxDto.setTableSql(tableSql.toString()).setOrderBySql(orderBySql.toString());
        }, tjfxExecutor).exceptionally(throwable -> {
            throw new GoffException(Constant.CodeStr.FAILURE, throwable.getMessage());
        });
        CompletableFuture<Void> future2 = CompletableFuture.runAsync(() -> {
            StringBuilder whereSql = builderTjfxWhereSql(queryDto, thbMap); //3、构建 whereSql
            String tjfxGroupBySql = queryDto.getTjfxFzzds().stream()
                    .map(item -> new StringBuilder(item.getBdDm()).append(DIAN).append(item.getLmDm()).append(NULL_STR))
                    .collect(Collectors.joining(",")); // 4、构建 groupBySql keypoint 由前台定制一个分组的顺序
            zdycxTjfxDto.setWhereSql(whereSql.toString());
            zdycxTjfxDto.setTjfxGroupBySql(tjfxGroupBySql);
        }, tjfxExecutor).exceptionally(throwable -> {
            throw new GoffException(Constant.CodeStr.FAILURE, throwable.getMessage());
        });

        try {
            CompletableFuture.allOf(future1, future2).get();
        } catch (Throwable ex) {
            // 捕获异常抛出处理
            throw new GoffException(Constant.CodeStr.FAILURE, ex.getMessage());
        }
        // 5、构建表头 和 selectSql
        ArrayList<ZdycxZslDto> tableHeads = Lists.newArrayList(queryDto.getTjfxFzzds());
        String selectJszSql = queryDto.getTjfxJszds().stream().map(tjfxJszd -> {
            ZdycxZslDto jszd = tjfxJszd.getJszd();
            tableHeads.add(jszd);// 添加上计算字段
            BdTjfxJsEnum anEnum = BdTjfxJsEnum.getEnum(tjfxJszd.getJsfs());
            String tbStringFormat0 = thbMap.get(BQ.getValue());
            if (ObjectUtil.isEmpty(tbStringFormat0)) return jszd.getLmDm();
            StringBuilder selectTbSql0 = anEnum.buildJszd(tbStringFormat0, jszd.getLmDm()).append(AS).append(jszd.getLmDm());
            if (ObjectUtil.isNotEmpty(tjfxJszd.getDbfs()))
                for (String dbf : tjfxJszd.getDbfs()) {
                    BdTjfxDbEnum dbEnum = BdTjfxDbEnum.getEnum(dbf);
                    String tjfxDb = ObjectUtil.equals(dbEnum.getValue(), TB.getValue()) ? "_TQ" : "_SQ";
                    ZdycxZslDto zdycxZslDto = BeanUtil.copyProperties(tjfxJszd.getJszd(), ZdycxZslDto.class);
                    zdycxZslDto.setLmKey(zdycxZslDto.getLmKey() + dbEnum.getValue()); // 代码转换不做处理
                    zdycxZslDto.setLmmc(zdycxZslDto.getLmmc() + "-" + dbEnum.getLabel());
                    zdycxZslDto.setTjfxDb(tjfxDb);
                    String tbStringFormat1 = thbMap.get(dbEnum.getValue());
                    StringBuilder selectTbSql1 = anEnum.buildJszd(tbStringFormat1, zdycxZslDto.getLmDm()).append(AS).append(zdycxZslDto.getLmDm() + tjfxDb);
                    selectTbSql0.append(",").append(selectTbSql1);
                    tableHeads.add(zdycxZslDto);// 添加上计算字段
                }
            return selectTbSql0.toString();
        }).collect(Collectors.joining(","));

        // 6、构建子查询的 selectSql 字段
        StringBuilder selectSql = new StringBuilder(zdycxTjfxDto.getTjfxGroupBySql()).append(",").append(selectJszSql);
        // 7、 构建统计分析 selectTjfxSql 字段
        String tjfxSelectSql = tableHeads.stream().map(item -> {
            if (ObjectUtil.isEmpty(item.getTjfxDb())) return item.getLmDm();
            return String.format(CONCAT_THB, item.getLmDm(), item.getLmDm() + item.getTjfxDb(), item.getLmDm(), "%", item.getLmKey());
        }).collect(Collectors.joining(","));
        zdycxTjfxDto.setSelectSql(selectSql.toString());
        zdycxTjfxDto.setTjfxSelectSql(tjfxSelectSql);
        Page<Map> page = new Page<>(queryDto.getPageNumber(), queryDto.getPageSize());
        Page<List<Map<String, Object>>> dataMap = zdycxExecMapper.selectTjfx(page, zdycxTjfxDto);
        Map<String, Object> returnData = new HashMap<>(3);
        returnData.put("tableHead", tableHeads);
        returnData.put("tableData", PageResult.build(dataMap));
        return returnData;
    }
}