package cn.gov.chinatax.gt4.swrdsm.core.mp.service;

import cn.gov.chinatax.gt4.swrdsm.core.mp.mapper.BaseMapperX;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.Serializable;
import java.util.List;

/**
 * @Copyright：Copyright (c) 2002-2023 Digitalchina CO.,LTD.  All rights reserved.
 * @Company：神州数码信息系统集成服务有限公司
 * @Department：税务地方大客户.CA
 * @Author：huax
 * @CreationTime：2023-03-01 11:10:00
 * @Version：1.0
 * @Compiler：1.8
 * @Description：BaseService
 */
public class BaseServiceX<M extends BaseMapperX<T>, T> {
    protected Logger log = LoggerFactory.getLogger(this.getClass());

    @Autowired
    protected M mapper;

    public M getMapper() {
        return this.mapper;
    }

    public void setMapper(M mapper) {
        this.mapper = mapper;
    }

    public T selectOne(T entity) {
        Wrapper<T> queryWrapper = new QueryWrapper<>(entity);
        return mapper.selectOne(queryWrapper);
    }

    public T selectById(Serializable id) {
        return mapper.selectById(id);
    }

    public List<T> selectListByIds(List<String> ids) {
        return mapper.selectBatchIds(ids);
    }

    public List<T> selectList(T entity) {
        Wrapper<T> queryWrapper = new QueryWrapper<>(entity);
        return mapper.selectList(queryWrapper);
    }

    public Integer selectCount(T entity) {
        Wrapper<T> queryWrapper = new QueryWrapper<>(entity);
        return mapper.selectCount(queryWrapper);
    }


    public Integer selectCountAll() {
        return mapper.selectCount(null);
    }

    public int insert(T entity) {
        return mapper.insert(entity);
    }

    public int delete(T entity) {
        Wrapper<T> updateWrapper = new UpdateWrapper<>(entity);
        return mapper.delete(updateWrapper);
    }

    public int deleteById(Serializable id) {
        return mapper.deleteById(id);
    }

    public int deleteByIds(List<String> ids) {
        return mapper.deleteBatchIds(ids);
    }

    public int updateById(T entity) {
        return mapper.updateById(entity);
    }

    public int updateByQuery(T entity, T query) {
        Wrapper<T> updateWrapper = new UpdateWrapper<>(query);
        return mapper.update(entity, updateWrapper);
    }
}
