package cn.gov.chinatax.gt4.swrdsm.service.zdycx;

import cn.gov.chinatax.gt4.swrdsm.core.assertions.AssertUtil;
import cn.gov.chinatax.gt4.swrdsm.core.mp.page.PageResult;
import cn.gov.chinatax.gt4.swrdsm.core.mp.service.BaseServiceX;
import cn.gov.chinatax.gt4.swrdsm.mapper.zdycx.ZdycxScjMapper;
import cn.gov.chinatax.gt4.swrdsm.pojo.domain.zdycx.ZdycxScj;
import cn.gov.chinatax.gt4.swrdsm.pojo.dto.zdycx.ZdycxScjDto;
import cn.gov.chinatax.gt4.swrdsm.pojo.dto.zdycx.ZdycxScjEditDto;
import cn.gov.chinatax.gt4.swrdsm.pojo.dto.zdycx.ZdycxScjQueryDto;
import cn.hutool.core.bean.BeanUtil;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static cn.gov.chinatax.gt4.swrdsm.util.enums.SwrdsmErrorCode.BIZ_ADD_FAIL;

/**
 * 业务层
 *
 * @author huax
 * @date 2023-11-22
 */
@Service
public class ZdycxScjService extends BaseServiceX<ZdycxScjMapper, ZdycxScj> {

    /**
     * 获取列表
     *
     * @param form
     * @return
     */
    public PageResult<ZdycxScjDto> getZdycxScjs(ZdycxScjQueryDto form) {
        // todo 获取当前登录人的税务人员代码
        Page<ZdycxScjDto> page = new Page<>(form.getPageNumber(), form.getPageSize());
        Page<ZdycxScjDto> resultPage = mapper.getZdycxScjs(page, form);
        return PageResult.build(resultPage);
    }

    /**
     * 获取
     *
     * @param id
     * @return
     */
    public ZdycxScjDto getZdycxScj(String id) {
        ZdycxScj zdycxScj = mapper.getZdycxScj(id);
        AssertUtil.isNotNull(zdycxScj, String.format("【自定义查询】 id：%s获取数据为空", id));
        return BeanUtil.copyProperties(zdycxScj, ZdycxScjDto.class);
    }

    /**
     * 新增
     *
     * @param edit
     * @return
     */
    @Transactional(rollbackFor = Exception.class)
    public String addZdycxScj(ZdycxScjEditDto edit) {
        ZdycxScj zdycxScj = new ZdycxScj();
        BeanUtil.copyProperties(edit, zdycxScj);
        zdycxScj.setYxbz("Y");
        int row = insert(zdycxScj);
        AssertUtil.isTrue(row > 0, BIZ_ADD_FAIL);
        return zdycxScj.getId();
    }
    /**
     * 根据主键集合删除
     *
     * @return
     */
    @Transactional(rollbackFor = Exception.class)
    public Boolean deleteZdycxScjs(List<String> ids) {
        int row = deleteByIds(ids);
        return row > 0 ? true : false;
    }
}