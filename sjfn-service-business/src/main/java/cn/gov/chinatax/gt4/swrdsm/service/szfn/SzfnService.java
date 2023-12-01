package cn.gov.chinatax.gt4.swrdsm.service.szfn;

import cn.gov.chinatax.gt4.swrdsm.core.assertions.AssertUtil;
import cn.gov.chinatax.gt4.swrdsm.pojo.dto.szfn.*;
import cn.hutool.core.util.ObjectUtil;
import com.google.common.collect.Lists;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.*;

/**
 * 数字赋能 service
 *
 * @author huax
 */
@Service
public class SzfnService {

    @Resource
    private ZhSwrdCsSjfnYwtxnrcsbService ywtxnrcsbService;
    private static final List<String> HK_PZX = Lists.newArrayList("注销税务登记", "退抵税费审批", "税（费）种认定");
    private static final List<String> HB_PZX = Lists.newArrayList("变更税务登记"
            , "修改设立税务登记信息（补偿）", "纳税人（扣缴义务人）身份信息报告", "工商部门登记信息查询确认", "个体工商户信息确认", "一照一码户信息确认");

    private static final List<SzfnHkHbPzDto> HB_HK_PZX = Lists.newArrayList(
            new SzfnHkHbPzDto("数据赋能","慧看","税务登记注销业务","注销税务登记","contain"),
            new SzfnHkHbPzDto("数据赋能","慧看","企业所得税汇算清缴退税","退抵税费审批","contain"),
            new SzfnHkHbPzDto("数据赋能","慧办","税（费）种认定","税（费）种认定","contain"),
            new SzfnHkHbPzDto("数据赋能","慧办","税务登记-变更税务登记","变更税务登记","equal"),
            new SzfnHkHbPzDto("数据赋能","慧办","税务登记-修改设立税务登记信息（补偿）","修改设立税务登记信息（补偿）","equal"),
            new SzfnHkHbPzDto("数据赋能","慧办","税务登记-纳税人（扣缴义务人）身份信息报告","纳税人（扣缴义务人）身份信息报告","equal"),
            new SzfnHkHbPzDto("数据赋能","慧办","税务登记-纳税人（扣缴义务人）身份信息报告","工商部门登记信息查询确认","equal"),
            new SzfnHkHbPzDto("数据赋能","慧办","税务登记-纳税人（扣缴义务人）身份信息报告","个体工商户信息确认","equal"),
            new SzfnHkHbPzDto("数据赋能","慧办","税务登记-纳税人（扣缴义务人）身份信息报告","一照一码户信息确认","equal")
    );


    public ZhSwrdCsSjfnYwtxnrcsbDto selectYwbltx(String gnbs) {
        AssertUtil.isNotNull(gnbs,"【数据赋能-小贴士】功能标识不能为空");
        ZhSwrdCsSjfnYwtxnrcsbDto zhSwrdCsSjfnYwtxnrcsbs =
                ywtxnrcsbService.getZhSwrdCsSjfnYwtxnrcsbs(new ZhSwrdCsSjfnYwtxnrcsbQueryDto()
                        .setGnbs(gnbs));
        return Optional.ofNullable(zhSwrdCsSjfnYwtxnrcsbs).orElseGet(ZhSwrdCsSjfnYwtxnrcsbDto::new);
    }


    public List<SzfnZjjgDto> selectZjjg(String llrsfid) {

        // todo 待开发 调用税支撑的微服务网关
        //  1、通过日志表拿到上次操作的最后时间，将时间起和时间止传递过去
        SzfnZjjgDto dto = new SzfnZjjgDto();
        dto.setSxmc("税 (费) 种认定");
        dto.setJcsj(new Date());
        dto.setTyshxydm("92610132MABOLAG86D");
        dto.setNsrmc("老陕肉夹馍小吃店");
        ArrayList<SzfnZjjgJcmxDto> jcmx = Lists.newArrayList(new SzfnZjjgJcmxDto("0", "企业所得税有效期限交叉")
                , new SzfnZjjgJcmxDto("0", "认定增值税未认定企业所得税")
                , new SzfnZjjgJcmxDto("1", "认定企业所得税未认定增值税")
                , new SzfnZjjgJcmxDto("1", "认定主税未认定附加税费")
                , new SzfnZjjgJcmxDto("1", "认定附加税费未认定主税")
                , new SzfnZjjgJcmxDto("1", "未认定代扣代缴个人所得税")
                , new SzfnZjjgJcmxDto("1", "主附税核定行业不一致")
                , new SzfnZjjgJcmxDto("1", "主附税申报期限不一致")
                , new SzfnZjjgJcmxDto("1", "主附税缴款期限不一致")
                , new SzfnZjjgJcmxDto("1", "主附税有效期起止不一致")
                , new SzfnZjjgJcmxDto("0", "主附税纳税期限不一致")
                , new SzfnZjjgJcmxDto("0", "行业中有广告业而没有有效的文化事业建设费")
        );
        dto.setJcmx(jcmx);
        return Lists.newArrayList(dto);

    }

    public Map<String, Object> selectYc(String shtyxyDm) {

        // todo 待开发 调用税支撑的微服务网关
        Map<String, Object> returnMap = new HashMap<>(4);
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
        returnMap.put("jbxx", ycjbxxDTO);
        returnMap.put("ywxx", ycYwxxDTO);
        return returnMap;
    }

    public Map<String, Boolean> selectHkAndHb(String ywblmc) {
        String[] split0 = ywblmc.split("-");
        Map<String, Boolean> returnData = new HashMap(3);
        returnData.put("hkbs", HK_PZX.stream().anyMatch(item -> item.contains(split0[0])));
        returnData.put("hbbs", HB_PZX.stream().anyMatch(item -> ObjectUtil.equals(item, split0[0])));
        return returnData;
    }


    public List<SzfnHkHbPzDto> selectV2HkAndHb() {
        return HB_HK_PZX;
    }
}
