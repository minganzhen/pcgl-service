package cn.gov.chinatax.gt4.swrdsm.service.nsphbrk;

import cn.gov.chinatax.gt4.swrdsm.core.assertions.AssertUtil;
import cn.gov.chinatax.gt4.swrdsm.mapper.nsphbrk.NsphbrkMapper;
import cn.gov.chinatax.gt4.swrdsm.pojo.dto.nsphbrk.NsphbrkDto;
import cn.gov.chinatax.gt4.swrdsm.pojo.vo.nsphbrk.NsphbrkQueryDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 风险点卡片 service
 *
 * @author zhaocn
 */
@Service
public class NsphbrkServiceImpl implements NsphbrkService {

    @Autowired
    private NsphbrkMapper mapper;

    @Override
    public List<NsphbrkDto> selectNsphbrk(NsphbrkQueryDto form) {
        String[] cxrqArray = form.getCxrq().split("-");
        AssertUtil.isTrue(cxrqArray.length == 3,"查询日期参数传入有误,格式应该为YYYY-MM-DD");
        form.setCxrqYear(cxrqArray[0]);
        form.setCxrqYearMonth(cxrqArray[0] + cxrqArray[1]);
        List<NsphbrkDto> resultPage = mapper.selectNsphbrk(form);
        resultPage.forEach(dto -> dto.setZsxmList(mapper.selectZsxmList(dto,form)));
        return resultPage;
    }
}
