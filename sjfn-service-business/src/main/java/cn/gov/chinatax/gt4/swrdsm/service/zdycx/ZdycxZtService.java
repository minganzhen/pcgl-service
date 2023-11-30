package cn.gov.chinatax.gt4.swrdsm.service.zdycx;

import cn.gov.chinatax.gt4.swrdsm.core.mp.service.BaseServiceX;
import cn.gov.chinatax.gt4.swrdsm.mapper.zdycx.ZdycxZtMapper;
import cn.gov.chinatax.gt4.swrdsm.pojo.domain.zdycx.ZdycxZt;
import cn.gov.chinatax.gt4.swrdsm.pojo.dto.zdycx.ZdycxZtDto;
import cn.gov.chinatax.gt4.swrdsm.pojo.dto.zdycx.ZdycxZtQueryDto;
import cn.gov.chinatax.gt4.swrdsm.pojo.dto.zdycx.ZdycxZtTree;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 业务层
 *
 * @author huax
 * @date 2023-11-21
 */
@Service
public class ZdycxZtService extends BaseServiceX<ZdycxZtMapper, ZdycxZt> {

    /**
     * 获取主题查询 树构造
     * @return
     */
    public List<ZdycxZtTree> getZdycxZts() {
        return mapper.getZdycxZts();
    }


}