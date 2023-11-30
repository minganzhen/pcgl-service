package cn.gov.chinatax.gt4.swrdsm.mapper.nsphbrk;

import cn.gov.chinatax.gt4.swrdsm.core.mp.mapper.BaseMapperX;
import cn.gov.chinatax.gt4.swrdsm.pojo.domain.nsphbrk.Nsphbrk;
import cn.gov.chinatax.gt4.swrdsm.pojo.dto.nsphbrk.NsphbrkDto;
import cn.gov.chinatax.gt4.swrdsm.pojo.dto.nsphbrk.ZsxmDto;
import cn.gov.chinatax.gt4.swrdsm.pojo.vo.nsphbrk.NsphbrkQueryDto;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 持久层
 *
 * @author zhaocn
 */
@Mapper
public interface NsphbrkMapper extends BaseMapperX<Nsphbrk> {

    /**
     * 获取纳税排行榜
     *
     * @param form
     * @return
     */
    List<NsphbrkDto> selectNsphbrk(@Param("form") NsphbrkQueryDto form);

    /**
     * 获取征收项目明细列表
     *
     * @param form
     * @return
     */
    List<ZsxmDto> selectZsxmList(@Param("dto") NsphbrkDto dto, @Param("form") NsphbrkQueryDto form);
}