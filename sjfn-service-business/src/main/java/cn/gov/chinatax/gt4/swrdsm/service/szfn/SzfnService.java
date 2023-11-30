package cn.gov.chinatax.gt4.swrdsm.service.szfn;


import cn.gov.chinatax.gt4.swrdsm.pojo.dto.szfn.SzfnZjjgDTO;

import java.util.List;
import java.util.Map;

/**
 * 数字赋能
 *
 * @author huax
 */
public interface SzfnService {

    /**
     * 查询业务办理提醒
     *
     * @return
     */
    List<String> selectYwbltx();

    /**
     * 查询智检结果
     * @return
     */
    List<SzfnZjjgDTO> selectZjjg();

    /**
     * 查询易查
     * @param shtyxyDm
     * @return
     */
    Map<String, Object> selectYc(String shtyxyDm);
}
