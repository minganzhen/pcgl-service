package cn.gov.chinatax.gt4.swrdsm.service.fxdkp;


import cn.gov.chinatax.gt4.swrdsm.core.mp.page.PageResult;
import cn.gov.chinatax.gt4.swrdsm.pojo.dto.fxdkp.FxdkpDto;
import cn.gov.chinatax.gt4.swrdsm.pojo.vo.fxdkp.FxdkpQueryDto;

import java.util.List;

/**
 * 数字赋能
 *
 * @author zhaocn
 */
public interface FxdkpService {
    PageResult<FxdkpDto> selectFxdkp(FxdkpQueryDto form);

}
