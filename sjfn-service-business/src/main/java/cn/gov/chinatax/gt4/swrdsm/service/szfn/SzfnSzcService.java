package cn.gov.chinatax.gt4.swrdsm.service.szfn;

import cn.gov.chinatax.gt4.swrdsm.pojo.dto.szfn.SzfnZjjgDto;
import cn.gov.chinatax.gt4.swrdsm.pojo.vo.szfn.SzfnZjjgQueryDtO;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * 数字赋能税支撑  service
 *
 * @author huax
 */
@Service
public class SzfnSzcService {

    public List<SzfnZjjgDto> selectZjjg(SzfnZjjgQueryDtO queryDtO) {
        // todo 待开发 税务端调用，查询表

        return null;
    }

    public Map<String, Object> selectYc(String shtyxyDm) {
        // todo 待开发 税务端，查询表
        return null;
    }
}
