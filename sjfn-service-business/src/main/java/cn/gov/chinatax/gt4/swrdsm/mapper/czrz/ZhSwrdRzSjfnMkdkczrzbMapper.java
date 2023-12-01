package cn.gov.chinatax.gt4.swrdsm.mapper.czrz;

import cn.gov.chinatax.gt4.swrdsm.core.mp.mapper.BaseMapperX;
import cn.gov.chinatax.gt4.swrdsm.pojo.domain.czrz.ZhSwrdRzSjfnMkdkczrzb;
import cn.gov.chinatax.gt4.swrdsm.pojo.dto.czrz.ZhSwrdRzSjfnMkdkczrzbDto;
import cn.gov.chinatax.gt4.swrdsm.pojo.dto.czrz.ZhSwrdRzSjfnMkdkczrzbQueryDto;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 持久层
 *
 * @author huax
 * @date 2023-12-01
 */
 @Mapper
public interface ZhSwrdRzSjfnMkdkczrzbMapper extends BaseMapperX<ZhSwrdRzSjfnMkdkczrzb> {

    /**
     * 获取列表
     *
     * @param form
     * @return
     */
    List<ZhSwrdRzSjfnMkdkczrzbDto> getZhSwrdRzSjfnMkdkczrzbs(@Param("form") ZhSwrdRzSjfnMkdkczrzbQueryDto form);
    
    /**
     * 获取
     *
     * @param id
     * @return
     */
    ZhSwrdRzSjfnMkdkczrzbDto getZhSwrdRzSjfnMkdkczrzb(@Param("id") String id);
}