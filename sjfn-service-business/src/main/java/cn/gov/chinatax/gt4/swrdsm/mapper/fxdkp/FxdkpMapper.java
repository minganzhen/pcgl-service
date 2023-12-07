package cn.gov.chinatax.gt4.swrdsm.mapper.fxdkp;

import cn.gov.chinatax.gt4.swrdsm.core.mp.mapper.BaseMapperX;
import cn.gov.chinatax.gt4.swrdsm.pojo.domain.fxdkp.Fxdkp;
import cn.gov.chinatax.gt4.swrdsm.pojo.dto.fxdkp.FxdkpDto;
import cn.gov.chinatax.gt4.swrdsm.pojo.vo.fxdkp.FxdkpQueryDto;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 持久层
 *
 * @author zhaocn
 */
 @Mapper
public interface FxdkpMapper extends BaseMapperX<Fxdkp> {

    /**
     * 获取风险点列表
     * @param form
     * @return
     */
    List<FxdkpDto> selectFxdkp(@Param("form") FxdkpQueryDto form);

}