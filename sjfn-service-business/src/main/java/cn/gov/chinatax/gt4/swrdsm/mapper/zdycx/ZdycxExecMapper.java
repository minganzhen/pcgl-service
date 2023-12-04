package cn.gov.chinatax.gt4.swrdsm.mapper.zdycx;

import cn.gov.chinatax.gt4.swrdsm.annotation.HjqDS;
import cn.gov.chinatax.gt4.swrdsm.pojo.dto.zdycx.ZdycxMxcxDto;
import cn.gov.chinatax.gt4.swrdsm.pojo.dto.zdycx.ZdycxTjfxDto;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * 持久层
 *
 * @author huax
 * @date 2023-11-21
 */
@Mapper
public interface ZdycxExecMapper {

    /**
     * 明细查询
     *
     * @param page
     * @param mxcxDto
     * @return
     */
    Page<List<Map<String, Object>>> selectMxcx(Page<Map> page, @Param("form") ZdycxMxcxDto mxcxDto);

    /**
     * 统计分析
     *
     * @param zdycxTjfxDto
     * @return
     */
    Page<List<Map<String, Object>>> selectTjfx(Page<Map> page, @Param("form") ZdycxTjfxDto zdycxTjfxDto);
}