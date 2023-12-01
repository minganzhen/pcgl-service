package cn.gov.chinatax.gt4.swrdsm.service.szfn;

import cn.gov.chinatax.gt4.swrdsm.core.mp.service.BaseServiceX;
import cn.gov.chinatax.gt4.swrdsm.mapper.szfn.ZhSwrdCsSjfnYwtxnrcsbMapper;
import cn.gov.chinatax.gt4.swrdsm.pojo.domain.szfn.ZhSwrdCsSjfnYwtxnrcsb;
import cn.gov.chinatax.gt4.swrdsm.pojo.dto.szfn.ZhSwrdCsSjfnYwtxnrcsbDto;
import cn.gov.chinatax.gt4.swrdsm.pojo.dto.szfn.ZhSwrdCsSjfnYwtxnrcsbQueryDto;
import org.springframework.stereotype.Service;

/**
 * 业务层
 *
 * @author huax
 * @date 2023-12-01
 */
@Service
public class ZhSwrdCsSjfnYwtxnrcsbService extends BaseServiceX<ZhSwrdCsSjfnYwtxnrcsbMapper, ZhSwrdCsSjfnYwtxnrcsb> {

    /**
     * 获取列表
     *
     * @param form
     * @return
     */
    public ZhSwrdCsSjfnYwtxnrcsbDto getZhSwrdCsSjfnYwtxnrcsbs(ZhSwrdCsSjfnYwtxnrcsbQueryDto form) {
         return mapper.getZhSwrdCsSjfnYwtxnrcsbs(form);
    }
}