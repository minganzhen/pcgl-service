package cn.gov.chinatax.gt4.swrdsm.util.enums;

import cn.gov.chinatax.gt4.swrdsm.pojo.dto.zdycx.ZdycxZslDto;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @Copyright：Copyright (c) 2002-2023 Digitalchina CO.,LTD.  All rights reserved.
 * @Company：神州数码信息系统集成服务有限公司
 * @Department：税务地方大客户.CA
 * @Author：huax
 * @CreationTime：2023-11-24 16:06:00
 * @Version：1.0
 * @Compiler：1.8
 * @Description：BdTjfxJsEnum 统计分析计算方式
 */
@Getter
@AllArgsConstructor
public enum BdTjfxJsEnum {


    SUM(" SUM(%s) ", "SUM", "求和"),
    COUNT(" COUNT(%s) ", "COUNT", "数量"),
    COUNT_DISTINCT(" COUNT(DISTINCT %s) ", "COUNT_DISTINCT", "数量去重"),
    AVG(" AVG(%s) ", "AVG", "平均值");

    private String valueformat;
    private String value;
    private String label;

    public static BdTjfxJsEnum getEnum(String value) {
        BdTjfxJsEnum result = null;
        BdTjfxJsEnum[] enums = BdTjfxJsEnum.values();
        for (BdTjfxJsEnum enum_ : enums) {
            if (enum_.getValue().equals(value)) {
                result = enum_;
                break;
            }
        }
        return result;
    }

    public StringBuilder buildJszd(ZdycxZslDto jszd) {
        return new StringBuilder(String.format(this.getValueformat(), jszd.getBdDm() + "." + jszd.getLmDm())).append(" AS ").append(jszd.getLmKey());
    }

    public StringBuilder buildJszd(String rqtjValue, String zdValue) {
        String CASE_WHEN = "CASE WHEN %s THEN %s END";
        return new StringBuilder(String.format(this.getValueformat(), String.format(CASE_WHEN, rqtjValue, zdValue)));
    }
}
