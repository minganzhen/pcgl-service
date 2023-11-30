package cn.gov.chinatax.gt4.swrdsm.mapper.zdycx;

import cn.gov.chinatax.gt4.swrdsm.core.mp.mapper.BaseMapperX;
import cn.gov.chinatax.gt4.swrdsm.pojo.domain.zdycx.ZdycxZt;
import cn.gov.chinatax.gt4.swrdsm.pojo.dto.zdycx.ZdycxZtTree;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 持久层
 *
 * @author huax
 * @date 2023-11-21
 */
 @Mapper
public interface ZdycxZtMapper extends BaseMapperX<ZdycxZt> {

    /**
     * 获取列表
     *
     * @return
     */
    List<ZdycxZtTree > getZdycxZts();
    
}