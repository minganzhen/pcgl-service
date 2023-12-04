package cn.gov.chinatax.gt4.swrdsm.service.fxdkp;

import cn.gov.chinatax.gt4.swrdsm.core.mp.page.PageResult;
import cn.gov.chinatax.gt4.swrdsm.mapper.fxdkp.FxdkpMapper;
import cn.gov.chinatax.gt4.swrdsm.pojo.common.PageResultApi;
import cn.gov.chinatax.gt4.swrdsm.pojo.dto.fxdkp.FxdkpDto;
import cn.gov.chinatax.gt4.swrdsm.pojo.vo.fxdkp.FxdkpQueryDto;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 风险点卡片 service
 *
 * @author zhaocn
 */
@Service
public class FxdkpServiceImpl implements FxdkpService {

    @Autowired
    private FxdkpMapper mapper;

    @Override
    public PageResultApi<FxdkpDto> selectFxdkp(FxdkpQueryDto form) {
        Page<FxdkpDto> page = new Page<>(form.getPageNumber(), form.getPageSize());
        Page<FxdkpDto> resultPage = mapper.selectFxdkp(page, form);
        return PageResult.buildApi(resultPage);
    }
}
