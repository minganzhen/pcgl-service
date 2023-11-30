package cn.gov.chinatax.gt4.swrdsm.service.nsphbrk;


import cn.gov.chinatax.gt4.swrdsm.pojo.dto.nsphbrk.NsphbrkDto;
import cn.gov.chinatax.gt4.swrdsm.pojo.vo.nsphbrk.NsphbrkQueryDto;

import java.util.List;

/**
 * 数字赋能
 *
 * @author zhaocn
 */
public interface NsphbrkService {
    List<NsphbrkDto> selectNsphbrk(NsphbrkQueryDto form);

}
