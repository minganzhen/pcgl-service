package cn.gov.chinatax.gt4.swrdsm.mapper.zdycx;

import cn.gov.chinatax.gt4.swrdsm.core.mp.mapper.BaseMapperX;
import cn.gov.chinatax.gt4.swrdsm.pojo.domain.zdycx.ZdycxBdglgx;
import cn.gov.chinatax.gt4.swrdsm.pojo.dto.zdycx.ZdycxBdglgxDto;
import cn.gov.chinatax.gt4.swrdsm.pojo.dto.zdycx.ZdycxBdglgxQueryDto;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Mapper;
import java.util.List;

/**
 * 持久层
 *
 * @author huax
 * @date 2023-11-22
 */
 @Mapper
public interface ZdycxBdglgxMapper extends BaseMapperX<ZdycxBdglgx> {

    /**
     * 获取列表
     *
     * @param form
     * @return
     */
    List<ZdycxBdglgxDto> getZdycxBdglgxs(@Param("form") ZdycxBdglgxQueryDto form);

    List<ZdycxBdglgxDto> getZdycxBdglgxByIds(@Param("ids") List<String> ids);
}