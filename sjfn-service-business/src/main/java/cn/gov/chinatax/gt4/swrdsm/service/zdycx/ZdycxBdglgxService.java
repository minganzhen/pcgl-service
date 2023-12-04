package cn.gov.chinatax.gt4.swrdsm.service.zdycx;

import cn.gov.chinatax.gt4.swrdsm.annotation.HjqDS;
import cn.gov.chinatax.gt4.swrdsm.core.assertions.AssertUtil;
import cn.gov.chinatax.gt4.swrdsm.core.mp.service.BaseServiceX;
import cn.gov.chinatax.gt4.swrdsm.mapper.zdycx.ZdycxBdglgxMapper;
import cn.gov.chinatax.gt4.swrdsm.pojo.domain.zdycx.ZdycxBdglgx;
import cn.gov.chinatax.gt4.swrdsm.pojo.dto.zdycx.ZdycxBdglgxDto;
import cn.gov.chinatax.gt4.swrdsm.pojo.dto.zdycx.ZdycxBdglgxQueryDto;
import com.baomidou.dynamic.datasource.annotation.DS;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 业务层
 *
 * @author huax
 * @date 2023-11-22
 */
@Service
@HjqDS
public class ZdycxBdglgxService extends BaseServiceX<ZdycxBdglgxMapper, ZdycxBdglgx> {

    /**
     * 获取列表根据表单代码
     *
     * @param form
     * @return
     */
    public List<ZdycxBdglgxDto> getZdycxBdglgxs(ZdycxBdglgxQueryDto form) {
        List<ZdycxBdglgxDto> dtoList = mapper.getZdycxBdglgxs(form);
        AssertUtil.isNotEmpty(dtoList, String.format("【自定义查询】表1：%s，表2：%s未在配置关联关系，请联系数据检查！ ", form.getBdDm1(), form.getBdDm2()));
        return dtoList;
    }

    /**
     * 查询是否存在关系
     *
     * @param form
     * @return
     */
    public Boolean selectSfczgx(ZdycxBdglgxQueryDto form) {
        Integer integer = selectCount(new ZdycxBdglgx().setBdDm1(form.getBdDm1()).setBdDm2(form.getBdDm2()));
        return integer > 0;
    }

    /**
     * 获取列表根据id
     *
     * @param ids
     * @return
     */
    public List<ZdycxBdglgxDto> getZdycxBdglgxs(List<String> ids) {
        List<ZdycxBdglgxDto> dtoList = mapper.getZdycxBdglgxByIds(ids);
        AssertUtil.isNotEmpty(dtoList, String.format("【自定义查询】id %s 未在配置关联关系，请联系数据检查！ ", ids.toString()));
        return dtoList;
    }


}