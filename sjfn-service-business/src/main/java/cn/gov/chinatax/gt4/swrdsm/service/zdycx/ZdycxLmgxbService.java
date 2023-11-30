package cn.gov.chinatax.gt4.swrdsm.service.zdycx;

import cn.gov.chinatax.gt4.swrdsm.core.assertions.AssertUtil;
import cn.gov.chinatax.gt4.swrdsm.core.mp.service.BaseServiceX;
import cn.gov.chinatax.gt4.swrdsm.mapper.zdycx.ZdycxLmgxbMapper;
import cn.gov.chinatax.gt4.swrdsm.pojo.domain.zdycx.ZdycxLmgxb;
import cn.gov.chinatax.gt4.swrdsm.pojo.dto.zdycx.ZdycxLmgxbQueryDto;
import cn.gov.chinatax.gt4.swrdsm.pojo.dto.zdycx.ZdycxTjXsDto;
import cn.gov.chinatax.gt4.swrdsm.pojo.dto.zdycx.ZdycxZslDto;
import cn.gov.chinatax.gt4.swrdsm.pojo.vo.zdycx.ZdycxTjFxBeforeQueryDto;
import cn.gov.chinatax.gt4.swrdsm.util.core.ValueLabel;
import cn.gov.chinatax.gt4.swrdsm.util.enums.BdTjfxDbEnum;
import cn.hutool.core.date.DateField;
import cn.hutool.core.date.DateTime;
import cn.hutool.core.date.DateUtil;
import cn.hutool.core.util.ObjectUtil;
import com.google.common.collect.Lists;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.*;
import java.util.stream.Collectors;

/**
 * 业务层
 *
 * @author huax
 * @date 2023-11-22
 */
@Service
@Slf4j
public class ZdycxLmgxbService extends BaseServiceX<ZdycxLmgxbMapper, ZdycxLmgxb> {

    private static final List<BdTjfxDbEnum> TB_LIST = Lists.newArrayList(BdTjfxDbEnum.TB);
    private static final List<BdTjfxDbEnum> TB_HB_LIST = Lists.newArrayList(BdTjfxDbEnum.TB, BdTjfxDbEnum.HB);
    public static final List<String> RQ_LIST = Lists.newArrayList("rq", "rqfw");

    /**
     * 获取展示列表
     *
     * @param form
     * @return
     */
    public Map<String, List<ZdycxZslDto>> selectLm(ZdycxLmgxbQueryDto form) {
        form.setJglbz("Y");
        List<ZdycxZslDto> dtoList = mapper.selectLm(form);
        // 这里使用 过滤方式 ，不通过分组，主要是为了保证顺序的一致
        Map<String, List<ZdycxZslDto>> returnMap = new LinkedHashMap<>(5);
        form.getBdDms().stream().forEach(bdDm -> {
            List<ZdycxZslDto> bdDmDto = dtoList.stream().filter(item -> ObjectUtil.equals(bdDm, item.getBdDm())).collect(Collectors.toList());
            AssertUtil.isNotEmpty(bdDmDto, String.format("【自定义查询】表单：%s 结果列集为空，请联系数据检查！", bdDm));
            returnMap.put(bdDm, bdDmDto);
        });
        return returnMap;
    }

    /**
     * 获取条件列表
     *
     * @param form
     * @return
     */
    public Map<String, List<ZdycxTjXsDto>> selectTj(ZdycxLmgxbQueryDto form) {
        List<ZdycxTjXsDto> dtoList = mapper.selectTj(form);
        // 这里使用 过滤方式 ，不通过分组，主要是为了保证顺序的一致
        AssertUtil.isNotEmpty(dtoList, String.format("【自定义查询】表单集合：%s 条件集为空，请联系数据检查！", form.getBdDms()));

        // 条件按照顺序去重
        Set<ZdycxTjXsDto> targetListDto = new LinkedHashSet();
        form.getBdDms().stream().forEach(bbDm -> {
            targetListDto.addAll(dtoList.stream().filter(item -> ObjectUtil.equals(bbDm, item.getBdDm())).collect(Collectors.toList()));
        });
        return targetListDto.stream().collect(Collectors.groupingBy(ZdycxTjXsDto::getTjlbz));
    }

    public Map<String, Object> selectTjfx(ZdycxTjFxBeforeQueryDto queryDto) {
        Set<ZdycxZslDto> bdZsls = queryDto.getBdZsls();
        Map<String, Object> returnMap = new HashMap<>(4);
        List<ZdycxZslDto> fxzdList = bdZsls.stream().filter(item -> ObjectUtil.equals(item.getTjfxfzbz(), "Y")).collect(Collectors.toList());
        List<ZdycxZslDto> tjfxkxzList = bdZsls.stream().filter(item -> ObjectUtil.equals(item.getTjfxkxzbz(), "Y")).collect(Collectors.toList());
        List<ZdycxTjXsDto> zdycxTjXsDtos = queryDto.getBdKxtjLabel().entrySet()
                .stream().map(item -> item.getValue()).flatMap(List::stream).collect(Collectors.toList());
        List<ZdycxTjXsDto> tjXsDtos = zdycxTjXsDtos.stream().filter(item -> RQ_LIST.contains(item.getTjlx())).collect(Collectors.toList());

        // 返回选择对比方式
        if (ObjectUtil.isNotEmpty(tjXsDtos)) {
            // 表示现在的选的日期超过 2个
            List<List<BdTjfxDbEnum>> dbfsListAll = new ArrayList<>();
            Boolean aBoolean = true;
            for (ZdycxTjXsDto dto : tjXsDtos) {
                aBoolean = buildJsfs(dto, queryDto, dbfsListAll);
                if (!aBoolean) break;
                if (dbfsListAll.size() > 1) break;
            }
            if (dbfsListAll.size() == 1 && aBoolean) {
                // 转value和label
                List<ValueLabel> valueLabels = dbfsListAll.get(0).stream().map(item -> new ValueLabel().setValue(item.getValue()).setLabel(item.getLabel())).collect(Collectors.toList());
                returnMap.put("dbfsList", valueLabels);
            }
        }
        returnMap.put("fxzdList", fxzdList);
        returnMap.put("tjfxkxzList", tjfxkxzList);
        return returnMap;
    }


    Boolean buildJsfs(ZdycxTjXsDto dto, ZdycxTjFxBeforeQueryDto queryDto, List<List<BdTjfxDbEnum>> dbfsListAll) {
        if (ObjectUtil.equals(dto.getTjlx(), "rq")
                && queryDto.getBdKxtjValue().containsKey(dto.getLmDm())
        ) {
            dbfsListAll.add(TB_HB_LIST);
        }
        if (ObjectUtil.equals(dto.getTjlx(), "rqfw")) {
            // 看一下日期值
            String sjqKey = dto.getLmDm() + "q";
            String sjzKey = dto.getLmDm() + "z";
            boolean q = queryDto.getBdKxtjValue().containsKey(sjqKey);
            boolean z = queryDto.getBdKxtjValue().containsKey(sjzKey);
            if (q && z) {
                DateTime dateQ = DateUtil.parse(queryDto.getBdKxtjValue().get(sjqKey).toString(), "yyyy-MM-dd");
                DateTime dateZ = DateUtil.parse(queryDto.getBdKxtjValue().get(sjzKey).toString(), "yyyy-MM-dd");
                if (dateQ.getField(DateField.YEAR) == dateZ.getField(DateField.YEAR)
                        && dateQ.getField(DateField.MONTH) != dateZ.getField(DateField.MONTH)
                ) {
                    dbfsListAll.add(TB_LIST);
                }
                if (dateQ.getField(DateField.YEAR) == dateZ.getField(DateField.YEAR)
                        && dateQ.getField(DateField.MONTH) == dateZ.getField(DateField.MONTH)
                ) {
                    dbfsListAll.add(TB_HB_LIST);
                }
            }
            if (q || z) {
                // 不允许添加数据
                return false;
            }
        }
        return true;
    }
}