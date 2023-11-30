package cn.gov.chinatax.gt4.swrdsm.util.enums;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;

/**
 * @Copyright：Copyright (c) 2002-2023 Digitalchina CO.,LTD.  All rights reserved.
 * @Company：神州数码信息系统集成服务有限公司
 * @Department：税务地方大客户.CA
 * @Author：huax
 * @CreationTime：2023-11-24 16:06:00
 * @Version：1.0
 * @Compiler：1.8
 * @Description：BdTjfxDbEnum 统计分析对比方式
 */
@Getter
@AllArgsConstructor
public enum BdTjfxDbEnum {


    BQ("BQ","本期"),
    TB("TB","同比"),
    HB("HB","环比");

    private String value;
    private String label;

    public static BdTjfxDbEnum getEnum(String value) {
        BdTjfxDbEnum result = null;
        BdTjfxDbEnum[] enums = BdTjfxDbEnum.values();
        for (BdTjfxDbEnum enum_ : enums) {
            if (enum_.getValue().equals(value)) {
                result = enum_;
                break;
            }
        }
        return result;
    }

}
