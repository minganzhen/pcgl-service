package cn.gov.chinatax.gt4.swrdsm.service.czrz;

import cn.gov.chinatax.gt4.swrdsm.core.mp.service.BaseServiceX;
import cn.gov.chinatax.gt4.swrdsm.mapper.czrz.ZhSwrdRzSjfnMkdkczrzbMapper;
import cn.gov.chinatax.gt4.swrdsm.pojo.domain.czrz.ZhSwrdRzSjfnMkdkczrzb;
import cn.gov.chinatax.gt4.swrdsm.pojo.dto.czrz.ZhSwrdRzSjfnMkdkczrzbDto;
import cn.gov.chinatax.gt4.swrdsm.pojo.dto.czrz.ZhSwrdRzSjfnMkdkczrzbEditDto;
import cn.gov.chinatax.gt4.swrdsm.pojo.dto.czrz.ZhSwrdRzSjfnMkdkczrzbQueryDto;
import cn.hutool.core.bean.BeanUtil;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.List;

/**
 * 业务层
 *
 * @author huax
 * @date 2023-12-01
 */
@Service
public class ZhSwrdRzSjfnMkdkczrzbService extends BaseServiceX<ZhSwrdRzSjfnMkdkczrzbMapper, ZhSwrdRzSjfnMkdkczrzb> {

    /**
     * 获取列表
     *
     * @param form
     * @return
     */
    public List<ZhSwrdRzSjfnMkdkczrzbDto> getZhSwrdRzSjfnMkdkczrzbs(ZhSwrdRzSjfnMkdkczrzbQueryDto form) {
        List<ZhSwrdRzSjfnMkdkczrzbDto> zhSwrdRzSjfnMkdkczrzbs = null;
        zhSwrdRzSjfnMkdkczrzbs = mapper.getZhSwrdRzSjfnMkdkczrzbs(form);
        return zhSwrdRzSjfnMkdkczrzbs;
    }
    
    /**
     * 获取
     *
     * @param id
     * @return
     */
    public ZhSwrdRzSjfnMkdkczrzbDto getZhSwrdRzSjfnMkdkczrzb(String id) {
        ZhSwrdRzSjfnMkdkczrzbDto zhSwrdRzSjfnMkdkczrzb = null;
        zhSwrdRzSjfnMkdkczrzb = mapper.getZhSwrdRzSjfnMkdkczrzb(id);
        return zhSwrdRzSjfnMkdkczrzb;
    }

    /**
     * 新增
     *
     * @param edit
     * @return
     */
    @Transactional(rollbackFor = Exception.class)
    public String addZhSwrdRzSjfnMkdkczrzb(ZhSwrdRzSjfnMkdkczrzbEditDto edit) {
        String result = null;

        ZhSwrdRzSjfnMkdkczrzb zhSwrdRzSjfnMkdkczrzb = BeanUtil.copyProperties(edit, ZhSwrdRzSjfnMkdkczrzb.class);
        int row = insert(zhSwrdRzSjfnMkdkczrzb);
        if (row > 0) {
            result = zhSwrdRzSjfnMkdkczrzb.getMkdkczcszjuuid();
        }

        return result;
    }
}