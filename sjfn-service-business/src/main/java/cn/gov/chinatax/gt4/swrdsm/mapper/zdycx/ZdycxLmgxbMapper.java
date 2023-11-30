package cn.gov.chinatax.gt4.swrdsm.mapper.zdycx;

import cn.gov.chinatax.gt4.swrdsm.core.mp.mapper.BaseMapperX;
import cn.gov.chinatax.gt4.swrdsm.pojo.domain.zdycx.ZdycxLmgxb;
import cn.gov.chinatax.gt4.swrdsm.pojo.dto.zdycx.ZdycxLmgxbDto;
import cn.gov.chinatax.gt4.swrdsm.pojo.dto.zdycx.ZdycxLmgxbQueryDto;
import cn.gov.chinatax.gt4.swrdsm.pojo.dto.zdycx.ZdycxTjXsDto;
import cn.gov.chinatax.gt4.swrdsm.pojo.dto.zdycx.ZdycxZslDto;
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
public interface ZdycxLmgxbMapper extends BaseMapperX<ZdycxLmgxb> {

    /**
     * 获取列表
     *
     * @param form
     * @return
     */
    List<ZdycxLmgxbDto> getZdycxLmgxbs(@Param("form") ZdycxLmgxbQueryDto form);

    /**
     * 获取列名
     *
     * @param form
     * @return
     */
    List<ZdycxZslDto> selectLm(@Param("form") ZdycxLmgxbQueryDto form);
    /**
     * 获取条件
     *
     * @param form
     * @return
     */
    List<ZdycxTjXsDto> selectTj(@Param("form") ZdycxLmgxbQueryDto form);

}