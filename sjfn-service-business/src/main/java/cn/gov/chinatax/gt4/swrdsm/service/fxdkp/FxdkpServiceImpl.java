package cn.gov.chinatax.gt4.swrdsm.service.fxdkp;

import cn.gov.chinatax.gt4.swrdsm.core.mp.page.PageResult;
import cn.gov.chinatax.gt4.swrdsm.core.mp.page.PaginationContext;
import cn.gov.chinatax.gt4.swrdsm.mapper.fxdkp.FxdkpMapper;
import cn.gov.chinatax.gt4.swrdsm.pojo.common.PageResultApi;
import cn.gov.chinatax.gt4.swrdsm.pojo.dto.fxdkp.FxdkpDto;
import cn.gov.chinatax.gt4.swrdsm.pojo.vo.fxdkp.FxdkpQueryDto;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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
    public PageResultApi<FxdkpDto> selectFxdkp(FxdkpQueryDto queryDto) {
        PaginationContext.trySetPagable(queryDto);
        List<FxdkpDto> resultPage = mapper.selectFxdkp(queryDto);
        return PageResult.buildApi(resultPage);
    }
}
