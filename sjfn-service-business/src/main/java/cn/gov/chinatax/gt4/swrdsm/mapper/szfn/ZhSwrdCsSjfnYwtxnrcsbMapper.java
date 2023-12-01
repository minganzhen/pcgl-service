package cn.gov.chinatax.gt4.swrdsm.mapper.szfn;

import cn.gov.chinatax.gt4.swrdsm.core.mp.mapper.BaseMapperX;
import cn.gov.chinatax.gt4.swrdsm.pojo.domain.szfn.ZhSwrdCsSjfnYwtxnrcsb;
import cn.gov.chinatax.gt4.swrdsm.pojo.dto.szfn.ZhSwrdCsSjfnYwtxnrcsbDto;
import cn.gov.chinatax.gt4.swrdsm.pojo.dto.szfn.ZhSwrdCsSjfnYwtxnrcsbQueryDto;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * 持久层
 *
 * @author huax
 * @date 2023-12-01
 */
 @Mapper
public interface ZhSwrdCsSjfnYwtxnrcsbMapper extends BaseMapperX<ZhSwrdCsSjfnYwtxnrcsb> {

    /**
     * 获取列表
     *
     * @param form
     * @return
     */
    ZhSwrdCsSjfnYwtxnrcsbDto getZhSwrdCsSjfnYwtxnrcsbs(@Param("form") ZhSwrdCsSjfnYwtxnrcsbQueryDto form);
    

}