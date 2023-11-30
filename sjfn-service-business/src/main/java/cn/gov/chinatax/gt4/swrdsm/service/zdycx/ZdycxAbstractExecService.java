package cn.gov.chinatax.gt4.swrdsm.service.zdycx;

import cn.gov.chinatax.gt4.swrdsm.core.assertions.AssertUtil;
import cn.gov.chinatax.gt4.swrdsm.core.mp.query.LambdaQueryWrapperX;
import cn.gov.chinatax.gt4.swrdsm.core.util.JsonUtil;
import cn.gov.chinatax.gt4.swrdsm.core.util.SqlExecJoinUtil;
import cn.gov.chinatax.gt4.swrdsm.mapper.zdycx.ZdycxLmgxbMapper;
import cn.gov.chinatax.gt4.swrdsm.pojo.domain.zdycx.ZdycxLmgxb;
import cn.gov.chinatax.gt4.swrdsm.pojo.dto.zdycx.ZdycxBdglgxDto;
import cn.gov.chinatax.gt4.swrdsm.pojo.dto.zdycx.ZdycxBdglgxQueryDto;
import cn.gov.chinatax.gt4.swrdsm.pojo.dto.zdycx.ZdycxTjXsDto;
import cn.gov.chinatax.gt4.swrdsm.pojo.dto.zdycx.ZdycxZslDto;
import cn.gov.chinatax.gt4.swrdsm.pojo.vo.zdycx.ZdycxMxcxQueryDto;
import cn.gov.chinatax.gt4.swrdsm.pojo.vo.zdycx.ZdycxTjcxQueryDto;
import cn.gov.chinatax.gt4.swrdsm.util.core.KeyValue;
import cn.gov.chinatax.gt4.swrdsm.util.enums.BdGlgxEnum;
import cn.gov.chinatax.gt4.swrdsm.util.enums.BdQzEnum;
import cn.gov.chinatax.gt4.swrdsm.util.enums.BdTjfxDbEnum;
import cn.hutool.core.date.DateField;
import cn.hutool.core.date.DateTime;
import cn.hutool.core.date.DateUtil;
import cn.hutool.core.util.ObjectUtil;
import com.google.common.collect.Lists;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import java.util.*;
import java.util.stream.Collectors;

import static cn.gov.chinatax.gt4.swrdsm.core.util.SqlExecJoinUtil.*;
import static cn.gov.chinatax.gt4.swrdsm.core.util.SqlExecJoinUtil.getDyhStr;

/**
 * @Copyright：Copyright (c) 2002-2023 Digitalchina CO.,LTD.  All rights reserved.
 * @Company：神州数码信息系统集成服务有限公司
 * @Department：税务地方大客户.CA
 * @Author：huax
 * @CreationTime：2023-11-24 10:43:00
 * @Version：1.0
 * @Compiler：1.8
 * @Description：ZdycxAbstractExecService 抽象类
 */
public abstract class ZdycxAbstractExecService implements ZdycxInterFaceExecService {
    protected static Map<String, List<BdQzEnum>> bdQzMap = new HashMap<>();
    protected static final List bqQzList = Lists.newArrayList("rqfw", "szfw");
    protected static final List qzStrList = Lists.newArrayList(Q, Z);
    protected static final List EQUAL_TJ = Lists.newArrayList("rq", "srk", "sz", "xldanx");
    protected static final List IN_TJ = Lists.newArrayList("xlduox", "xlsduox");
    @Resource
    private ZdycxBdglgxService bdglgxService;
    @Resource
    private ZdycxLmgxbMapper zdycxLmgxbMapper;

    // 初始化缓存
    @PostConstruct
    public void initBdQzEnum() {
        List<ZdycxLmgxb> zdycxLmgxbs = zdycxLmgxbMapper.selectList(
                new LambdaQueryWrapperX<ZdycxLmgxb>().in(ZdycxLmgxb::getTjlbz, Lists.newArrayList("0", "1", "2"))
                        .in(ZdycxLmgxb::getTjlx, Lists.newArrayList("rqfw", "szfw")).orderByAsc(ZdycxLmgxb::getBdDm)
        );
        Map<String, List<ZdycxLmgxb>> listMap = zdycxLmgxbs.stream().collect(Collectors.groupingBy(ZdycxLmgxb::getBdDm));
        for (Map.Entry<String, List<ZdycxLmgxb>> entry : listMap.entrySet()) {
            String key = entry.getKey();
            List<ZdycxLmgxb> value = entry.getValue();
            if (value.isEmpty()) continue;
            Long round = Math.round(value.size() * 2 / 0.75);
            List<BdQzEnum> list = new ArrayList<>(round.intValue());
            value.stream().forEach(item -> {
                list.add(new BdQzEnum(getQStr(item.getLmDm()), item.getLmDm(), SqlExecJoinUtil.GT, item.getBdDm()));
                list.add(new BdQzEnum(getZStr(item.getLmDm()), item.getLmDm(), SqlExecJoinUtil.LT, item.getBdDm()));
            });
            bdQzMap.put(key, list);
        }
    }

    /**
     * 构建 tableSql
     *
     * @param queryDto
     * @return
     */
    public StringBuilder builderTableSql(ZdycxMxcxQueryDto queryDto) {
        StringBuilder TableSql = new StringBuilder();
        // 1、构建 tableSql
        KeyValue<String, String> bd01 = null;
        KeyValue<String, String> bd02 = null;
        KeyValue<String, String> bd03 = null;

        for (int i = 0; i < queryDto.getBdDms().size(); i++) {
            KeyValue<String, String> bd = queryDto.getBdDms().get(i);
            if (i == 0) {
                bd01 = bd;
                TableSql.append(bd.getValue())
                        .append(NULL_STR)
                        .append(bd.getKey())
                        .append(NULL_STR);
            }
            // 表一二 关联
            if (i == 1) {
                bd02 = bd;
                BdGlgxEnum anEnum = BdGlgxEnum.getEnum(queryDto.getBdGlgxLx());
                AssertUtil.isNotNull(anEnum, String.format("【自定义查询】 表单关联关系枚举:%s 找不到配置，请联系管理员！", queryDto.getBdGlgxLx()));
                List<ZdycxBdglgxDto> zdycxBdglgxes = bdglgxService.getZdycxBdglgxs(queryDto.getBdGlgxs());
                getLeftOrInner(TableSql, bd, zdycxBdglgxes, anEnum);
            }
            // 表二三 关联
            if (i == 2) {
                bd03 = bd;
                List<ZdycxBdglgxDto> zdycxBdglgxes = bdglgxService.getZdycxBdglgxs(new ZdycxBdglgxQueryDto()
                        .setBdDm1(bd02.getKey())
                        .setBdDm2(bd.getKey()));
                getLeftOrInner(TableSql, bd, zdycxBdglgxes, BdGlgxEnum.LEFT);
            }
        }
        return TableSql;
    }

    /**
     * 构建统计分析 tjfxWhereSql
     *
     * @param queryDto
     * @param thbMap
     * @return
     */
    public StringBuilder builderTjfxWhereSql(ZdycxTjcxQueryDto queryDto, Map<String, String> thbMap) {
        StringBuilder whereSql = new StringBuilder(" 1 = 1 ");
        List<ZdycxTjXsDto> zdycxTjXsDtos = queryDto.getBdKxtjLabel().entrySet()
                .stream().map(item -> item.getValue()).flatMap(List::stream).collect(Collectors.toList());

        queryDto.getTjfxJszds().stream().map(item -> item.getDbfs()).flatMap(List::stream)
                .collect(Collectors.toSet()).stream().forEach(s -> {
                    thbMap.put(s, s);
                });
        boolean anyMatch = zdycxTjXsDtos.stream().anyMatch(item -> bqQzList.contains(item.getTjlx()));
        List<ZdycxTjXsDto> rqfwList = zdycxTjXsDtos.stream().filter(item -> ObjectUtil.equals(item.getTjlx(), "rqfw")).collect(Collectors.toList());
        Map<String, Object> bdKxtjValue = queryDto.getBdKxtjValue();

        // 不存在同环比就走原逻辑
        if (ObjectUtil.isAllNotEmpty(thbMap, rqfwList)) {
            // 表示存在同环比
            for (ZdycxTjXsDto dto : rqfwList) {
                String rqq = dto.getLmDm() + qzStrList.get(0);
                String rqz = dto.getLmDm() + qzStrList.get(1);
                if (bdKxtjValue.containsKey(rqq) && bdKxtjValue.containsKey(rqz)) {
                    whereSql.append(AND).append(" ( ");
                    //存在一个可以退出循环了
                    String zddm = new StringBuilder(dto.getBdDm()).append(DIAN).append(dto.getLmDm()).toString();
                    String zdValue = String.format(TO_CHAR_RQ, zddm);
                    Object valueQ = bdKxtjValue.get(rqq);
                    Object valueZ = bdKxtjValue.get(rqz);
                    StringBuilder dateSql0 = getWhereQzSql(zdValue, valueQ, valueZ);
                    whereSql.append(dateSql0);
                    thbMap.put(BdTjfxDbEnum.BQ.getValue(), dateSql0.toString());

                    if (thbMap.containsKey(BdTjfxDbEnum.TB.getValue())) {
                        whereSql.append(" OR ");
                        String dateValueQ = getLastYearDate(valueQ);
                        String dateValueZ = getLastYearDate(valueZ);
                        StringBuilder dateSql1 = getWhereQzSql(zdValue, dateValueQ, dateValueZ);
                        whereSql.append(dateSql1);
                        thbMap.put(BdTjfxDbEnum.TB.getValue(), dateSql1.toString());
                    }
                    if (thbMap.containsKey(BdTjfxDbEnum.HB.getValue())) {
                        whereSql.append(" OR ");
                        String dateValueQ = getLastMonthDate(valueQ);
                        String dateValueZ = getLastMonthDate(valueZ);
                        StringBuilder dateSql2 = getWhereQzSql(zdValue, dateValueQ, dateValueZ);
                        whereSql.append(dateSql2);
                        thbMap.put(BdTjfxDbEnum.HB.getValue(), dateSql2.toString());
                    }
                    whereSql.append(" ) ");
                    // 清除 2个日期key
                    bdKxtjValue.remove(rqq);
                    bdKxtjValue.remove(rqz);
                    break; // 退出循环
                }
            }
        }
        for (Map.Entry<String, Object> objectEntry : bdKxtjValue.entrySet()) {
            // 1、先从特殊数中
            String key = objectEntry.getKey();
            Object value = objectEntry.getValue();
            if (ObjectUtil.isEmpty(value)) continue; // 为空跳出本次循环
            BdQzEnum anEnum = null;
            if (anyMatch && qzStrList.contains(key.substring(key.length() - 1, key.length()))) {
                for (KeyValue<String, String> bdDm : queryDto.getBdDms()) {
                    anEnum = BdQzEnum.getEnum(bdQzMap.get(bdDm.getKey()), key);
                    if (ObjectUtil.isNotEmpty(anEnum)) break;
                }
                // 找到具体的别名
                if (ObjectUtil.isNotEmpty(anEnum)) {
                    whereSql.append(anEnum.buildWhereSql(value));
                }
            }
            if (anEnum == null) {
                // 找到别名 拼接sql
                ZdycxTjXsDto zdycxTjXsDto = getZdycxTjXsDto(queryDto.getBdKxtjLabel(), key);
                // 根据条件类型拼接sql
                whereSql.append(getTjcxWhereSql(zdycxTjXsDto, value, thbMap));
            }
        }
        return whereSql;
    }

    /**
     * getLastYearDate
     *
     * @param valueQ
     * @return
     */
    private static String getLastYearDate(Object valueQ) {
        DateTime parse = DateUtil.parse(valueQ.toString(), "yyyy-MM-dd");
        parse.setField(DateField.YEAR, parse.getField(DateField.YEAR) - 1);
        String dateValue = DateUtil.format(parse, "yyyy-MM-dd");
        return dateValue;
    }

    /**
     * getLastMonthDate
     *
     * @param valueQ
     * @return
     */
    private static String getLastMonthDate(Object valueQ) {
        DateTime parse = DateUtil.parse(valueQ.toString(), "yyyy-MM-dd");
        parse.setField(DateField.MONTH, parse.getField(DateField.MONTH) - 1);
        String dateValue = DateUtil.format(parse, "yyyy-MM-dd");
        return dateValue;
    }

    /**
     * 获取自定义查询展示列
     *
     * @param queryDto
     * @return
     */
    protected static Set<ZdycxZslDto> getZdycxZslDtos(ZdycxMxcxQueryDto queryDto) {
        Set<ZdycxZslDto> tableHeadSet = new LinkedHashSet<>();
        for (Map.Entry<String, List<ZdycxZslDto>> entry : queryDto.getBdZsls().entrySet()) {
            tableHeadSet.addAll(entry.getValue().stream().sorted().collect(Collectors.toList())); // 在处理一次排序问题
        }
        return tableHeadSet;
    }

    /**
     * 获取时间起止 sql
     *
     * @param zdValue
     * @param valueQ
     * @param valueZ
     * @return
     */
    protected StringBuilder getWhereQzSql(String zdValue, Object valueQ, Object valueZ) {
        StringBuilder dateSql0 = new StringBuilder();
        dateSql0.append(" ( ");
        dateSql0.append(zdValue).append(GT).append(getDyhStr(valueQ.toString()));
        dateSql0.append(AND);
        dateSql0.append(zdValue).append(LT).append(getDyhStr(valueZ.toString()));
        dateSql0.append(" ) ");
        return dateSql0;
    }

    /**
     * 构建 whereSql
     *
     * @param queryDto
     * @return
     */
    public StringBuilder builderWhereSql(ZdycxMxcxQueryDto queryDto) {
        StringBuilder whereSql = new StringBuilder(" 1 = 1 ");
        List<ZdycxTjXsDto> zdycxTjXsDtos = queryDto.getBdKxtjLabel().entrySet()
                .stream().map(item -> item.getValue()).flatMap(List::stream).collect(Collectors.toList());
        boolean anyMatch = zdycxTjXsDtos.stream().anyMatch(item -> bqQzList.contains(item.getTjlx()));

        for (Map.Entry<String, Object> objectEntry : queryDto.getBdKxtjValue().entrySet()) {
            // 1、先从特殊数中
            String key = objectEntry.getKey();
            Object value = objectEntry.getValue();
            if (ObjectUtil.isEmpty(value)) continue; // 为空跳出本次循环
            BdQzEnum anEnum = null;
            if (anyMatch && qzStrList.contains(key.substring(key.length() - 1, key.length()))) {
                for (KeyValue<String, String> bdDm : queryDto.getBdDms()) {
                    anEnum = BdQzEnum.getEnum(bdQzMap.get(bdDm.getKey()), key);
                    if (ObjectUtil.isNotEmpty(anEnum)) break;
                }
                // 找到具体的别名
                if (ObjectUtil.isNotEmpty(anEnum)) {
                    whereSql.append(anEnum.buildWhereSql(value));
                }
            }
            if (anEnum == null) {
                // 找到别名 拼接sql
                ZdycxTjXsDto zdycxTjXsDto = getZdycxTjXsDto(queryDto.getBdKxtjLabel(), key);
                // 根据条件类型拼接sql
                whereSql.append(getWhereSql(zdycxTjXsDto, value));
            }
        }
        return whereSql;
    }

    /**
     * 构建 OrderBySql
     *
     * @param tableHeadSet
     * @return
     */
    protected static StringBuilder builderOrderBySql(Set<ZdycxZslDto> tableHeadSet) {
        StringBuilder orderBySql = new StringBuilder();
        String orderByStr = tableHeadSet.stream().filter(item -> ObjectUtil.notEqual(item.getPxfs(), "N"))
                .map(item -> new StringBuilder(getTableDianStr(item.getBdDm(), item.getLmDm())).append(NULL_STR).append(item.getPxfs()).toString())
                .collect(Collectors.joining(","));
        orderBySql.append(orderByStr);
        return orderBySql;
    }

    /**
     * 构建 SelectSql
     *
     * @param tableHeadSet
     * @return
     */
    protected static StringBuilder builderSelectSql(Set<ZdycxZslDto> tableHeadSet) {
        StringBuilder selectSql = new StringBuilder();
        String selectStr = tableHeadSet.stream().map(item ->
                        new StringBuilder(item.getBdDm()).append(DIAN).append(item.getLmDm()).toString())
                .collect(Collectors.joining(","));
        selectSql.append(selectStr);
        return selectSql;
    }

    /**
     * 明细查询 whereSql 构建
     *
     * @param zdycxTjXsDto
     * @param value
     * @return
     */
    protected StringBuilder getWhereSql(ZdycxTjXsDto zdycxTjXsDto, Object value) {
        StringBuilder whereSql = new StringBuilder(AND).append(getTableDianStr(zdycxTjXsDto.getBdDm(), zdycxTjXsDto.getLmDm()));
        /**
         * 条件类型
         * rq,日期；
         * rqfw，日期范围；
         * dr,导入；
         * srk，输入框；
         * sz，数字金额；
         * szfw，数字金额范围；
         * xldanx，下来单选；
         * xlduox，下来多选；
         * xlsduox，树多选';
         */
        if (EQUAL_TJ.contains(zdycxTjXsDto.getTjlx())) {
            whereSql.append(EQUAL);
            switch (zdycxTjXsDto.getTjlx()) {
                case "rq":
                    whereSql.append(getDyhStr(value));
                    break;
                case "sz":
                    whereSql.append(value.toString());
                    break;
                default:
                    whereSql.append(getDyhStr(value));
            }

        } else if (IN_TJ.contains(zdycxTjXsDto.getTjlx())) {
            whereSql.append(IN);
            // 将value 装换成 List
            List<String> valueList = JsonUtil.jsonToList(JsonUtil.toJsonString(value), String.class);
            String inValue = valueList.stream().map(item -> getDyhStr(item)).collect(Collectors.joining(DOU_HAO));
            switch (zdycxTjXsDto.getTjlx()) {
                case "xlduox":
                    whereSql.append(inValue);
                    break;
                case "xlsduox":
                    whereSql.append(inValue);
                    break;
            }
        }
        return whereSql.append(NULL_STR);
    }

    /**
     * 统计查询 whereSql 处理
     *
     * @param zdycxTjXsDto
     * @param value
     * @param thbMap
     * @return
     */
    protected StringBuilder getTjcxWhereSql(ZdycxTjXsDto zdycxTjXsDto, Object value, Map<String, String> thbMap) {
        if (ObjectUtil.equals("rq", zdycxTjXsDto.getTjlx()))
            return getTjcxWhereSqlToRq(zdycxTjXsDto, value, thbMap);
        StringBuilder whereSql = new StringBuilder(AND).append(getTableDianStr(zdycxTjXsDto.getBdDm(), zdycxTjXsDto.getLmDm()));
        /**
         * 条件类型
         * rq,日期；
         * rqfw，日期范围；
         * dr,导入；
         * srk，输入框；
         * sz，数字金额；
         * szfw，数字金额范围；
         * xldanx，下来单选；
         * xlduox，下来多选；
         * xlsduox，树多选';
         */
        if (EQUAL_TJ.contains(zdycxTjXsDto.getTjlx())) {
            whereSql.append(EQUAL);
            switch (zdycxTjXsDto.getTjlx()) {
                case "sz":
                    whereSql.append(value.toString());
                    break;
                default:
                    whereSql.append(getDyhStr(value));
            }
        } else if (IN_TJ.contains(zdycxTjXsDto.getTjlx())) {
            whereSql.append(IN);
            // 将value 装换成 List
            List<String> valueList = JsonUtil.jsonToList(JsonUtil.toJsonString(value), String.class);
            String inValue = valueList.stream().map(item ->
                    getDyhStr(item)).collect(Collectors.joining(DOU_HAO));
            switch (zdycxTjXsDto.getTjlx()) {
                case "xlduox":
                    whereSql.append(inValue);
                    break;
                case "xlsduox":
                    whereSql.append(inValue);
                    break;
            }
        }
        return whereSql.append(NULL_STR);
    }

    private static StringBuilder getTjcxWhereSqlToRq(ZdycxTjXsDto zdycxTjXsDto, Object value, Map<String, String> thbMap) {
        StringBuilder whereSql = new StringBuilder(AND);
        StringBuilder zddm = new StringBuilder(getTableDianStr(zdycxTjXsDto.getBdDm(), zdycxTjXsDto.getLmDm()));
        String zdValue = String.format(SqlExecJoinUtil.TO_CHAR_RQ, zddm);
        if (ObjectUtil.isEmpty(thbMap))
            return whereSql.append(zdValue).append(EQUAL).append(getDyhStr(value));
        whereSql.append(" ( ");
        StringBuilder dateSql0 = new StringBuilder(zdValue).append(EQUAL).append(getDyhStr(value));
        whereSql.append(dateSql0);
        thbMap.put(BdTjfxDbEnum.BQ.getValue(), dateSql0.toString()); // 添加第一个值
        if (thbMap.containsKey(BdTjfxDbEnum.TB.getValue())) {
            whereSql.append(" OR ");
            String dateValue = getLastYearDate(value);
            StringBuilder dateSql = new StringBuilder(zdValue).append(EQUAL).append(getDyhStr(dateValue));
            whereSql.append(dateSql);
            thbMap.put(BdTjfxDbEnum.TB.getValue(), dateSql.toString());
        }
        if (thbMap.containsKey(BdTjfxDbEnum.HB.getValue())) {
            whereSql.append(" OR ");
            String dateValue = getLastMonthDate(value);
            StringBuilder dateSql = new StringBuilder(zdValue).append(EQUAL).append(getDyhStr(dateValue));
            whereSql.append(dateSql);
            thbMap.put(BdTjfxDbEnum.HB.getValue(), dateSql.toString());
        }
        whereSql.append(" ) ");
        return whereSql;
    }

    /**
     * 获取查询条件中 Dm的别名
     *
     * @param bdKxtjLabel
     * @param key
     * @return
     */
    protected ZdycxTjXsDto getZdycxTjXsDto(Map<String, List<ZdycxTjXsDto>> bdKxtjLabel, String key) {
        ZdycxTjXsDto dto = null;
        Set<Map.Entry<String, List<ZdycxTjXsDto>>> entries = bdKxtjLabel.entrySet();
        for (Map.Entry<String, List<ZdycxTjXsDto>> entry : entries) {
            for (ZdycxTjXsDto zdycxTjXsDto : entry.getValue()) {
                if (ObjectUtil.equals(zdycxTjXsDto.getLmDm(), key)) {
                    dto = zdycxTjXsDto;
                    break;
                }
            }
            if (ObjectUtil.isNotEmpty(dto)) break;
        }
        return dto;
    }

    /**
     * getLeftOrInner 连接
     *
     * @param TableSql
     * @param bd
     * @param zdycxBdglgxes
     * @param bdGlgxEnum
     */
    protected static void getLeftOrInner(StringBuilder TableSql
            , KeyValue<String, String> bd
            , List<ZdycxBdglgxDto> zdycxBdglgxes
            , BdGlgxEnum bdGlgxEnum
    ) {

        TableSql.append(bdGlgxEnum.getValue())
                .append(bd.getValue())
                .append(NULL_STR)
                .append(bd.getKey())
                .append(NULL_STR)
                .append(ON);
        for (int i = 0; i < zdycxBdglgxes.size(); i++) {
            ZdycxBdglgxDto bdglgx = zdycxBdglgxes.get(i);
            if (i != 0) {
                TableSql.append(AND);
            }
            TableSql.append(getTableDianStr(bdglgx.getBdDm1(), bdglgx.getGlzdDm1()));
            TableSql.append(EQUAL);
            TableSql.append(getTableDianStr(bdglgx.getBdDm2(), bdglgx.getGlzdDm2()));
        }
    }
}
