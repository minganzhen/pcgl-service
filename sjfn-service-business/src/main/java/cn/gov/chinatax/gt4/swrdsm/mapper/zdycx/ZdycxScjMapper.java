package cn.gov.chinatax.gt4.swrdsm.mapper.zdycx;

import cn.gov.chinatax.gt4.swrdsm.core.mp.mapper.BaseMapperX;
import cn.gov.chinatax.gt4.swrdsm.pojo.domain.zdycx.ZdycxScj;
import cn.gov.chinatax.gt4.swrdsm.pojo.dto.zdycx.ZdycxScjDto;
import cn.gov.chinatax.gt4.swrdsm.pojo.dto.zdycx.ZdycxScjQueryDto;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 持久层
 *
 * @author huax
 * @date 2023-11-22
 */
 @Mapper
public interface ZdycxScjMapper extends BaseMapperX<ZdycxScj> {

    /**
     * 获取列表
     *
     * @param form
     * @return
     */
    List<ZdycxScjDto> getZdycxScjs(@Param("form") ZdycxScjQueryDto form);
    
    /**
     * 获取
     *
     * @param id
     * @return
     */
    ZdycxScj getZdycxScj(@Param("id") String id);
}