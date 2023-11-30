package cn.gov.chinatax.gt4.swrdsm.service.szfn;

import cn.gov.chinatax.gt4.swrdsm.pojo.dto.szfn.SzfnYcYwxxDTO;
import cn.gov.chinatax.gt4.swrdsm.pojo.dto.szfn.SzfnYcjbxxDTO;
import cn.gov.chinatax.gt4.swrdsm.pojo.dto.szfn.SzfnZjjgDTO;
import cn.gov.chinatax.gt4.swrdsm.util.core.KeyValue;
import com.google.common.collect.Lists;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.*;

/**
 * 数字赋能 service
 *
 * @author huax
 */
@Service
public class SzfnServiceImpl implements SzfnService {


    @Override
    public List<String> selectYwbltx() {
        return Lists.newArrayList("1.认定增值税未认定企业所得税、认定企业所得税未认定增值税、认定主税未认定附加税费、认定附加税费未认定主税、未认定代扣代缴个人所得税;"
                ,"2.主附税核定行业不一致、申报期限不一致、缴款期限不一致、有效期起止不一致、纳税期限不一致、企业所得税有效期限交叉:"
                ,"3.行业中有广告业而没有有效的文化事业建设费");
        // todo 待开发
    }

    @Override
    public List<SzfnZjjgDTO> selectZjjg() {

        SzfnZjjgDTO dto = new SzfnZjjgDTO();
        dto.setSxmc("税 (费) 种认定");
        dto.setJcsj(new Date());
        dto.setShtyxyDm("92610132MABOLAG86D");
        dto.setNsrmc("老陕肉夹馍小吃店");
        ArrayList<KeyValue> jtqk = Lists.newArrayList(new KeyValue("Y", "企业所得税有效期限交叉")
                , new KeyValue("Y", "认定增值税未认定企业所得税")
                , new KeyValue("N", "认定企业所得税未认定增值税")
                , new KeyValue("Y", "认定主税未认定附加税费")
                , new KeyValue("Y", "认定附加税费未认定主税")
                , new KeyValue("Y", "未认定代扣代缴个人所得税")
                , new KeyValue("Y", "主附税核定行业不一致")
                , new KeyValue("Y", "主附税申报期限不一致")
                , new KeyValue("Y", "主附税缴款期限不一致")
                , new KeyValue("Y", "主附税有效期起止不一致")
                , new KeyValue("Y", "主附税纳税期限不一致")
                , new KeyValue("Y", "行业中有广告业而没有有效的文化事业建设费")
        );
        dto.setJtqk(jtqk);
        return Lists.newArrayList(dto);

        // todo 待开发
    }

    @Override
    public Map<String, Object> selectYc(String shtyxyDm) {

        Map<String,Object> returnMap = new HashMap<>(4);

        SzfnYcjbxxDTO ycjbxxDTO = new SzfnYcjbxxDTO();
        ycjbxxDTO.setKsrq("2020年12月1日");
        ycjbxxDTO.setNsxydj("B级");
        ycjbxxDTO.setYbnsrrdsj("2020年12月1日");
        ycjbxxDTO.setSdpsxlb("数电票授信类别");
        ycjbxxDTO.setSdpsxed(BigDecimal.valueOf(20));

        SzfnYcYwxxDTO ycYwxxDTO = new SzfnYcYwxxDTO();
        ycYwxxDTO.setJ3gzrndsrze(BigDecimal.valueOf(76937605.88));
        ycYwxxDTO.setJ3gzrndskjrkze(BigDecimal.valueOf(2875280));
        ycYwxxDTO.setJ3gzrndzhsfl("3.737156%");
        ycYwxxDTO.setJ3gzrndzzsjrkje(BigDecimal.valueOf(172516.8));
        ycYwxxDTO.setJ3gzrndqysdsjrkje(BigDecimal.valueOf(143764));
        ycYwxxDTO.setJ3gzrndfcsjrkje(BigDecimal.valueOf(97625.11));
        ycYwxxDTO.setJ3gzrndcztdsysjrkje(BigDecimal.valueOf(48813));
        ycYwxxDTO.setJ3gzrndtdzzsjrkje(BigDecimal.valueOf(0));
        ycYwxxDTO.setJ3gzrndyhsjrkje(BigDecimal.valueOf(24406));
        returnMap.put("jbxx",ycjbxxDTO);
        returnMap.put("ywxx",ycYwxxDTO);

        return returnMap;

        // todo 待开发
    }


}
