package cn.gov.chinatax.gt4.swrdsm.util.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @Copyright：Copyright (c) 2002-2023 Digitalchina CO.,LTD.  All rights reserved.
 * @Company：神州数码信息系统集成服务有限公司
 * @Department：税务地方大客户.CA
 * @Author：huax
 * @CreationTime：2023-11-23 19:19:00
 * @Version：1.0
 * @Compiler：1.8
 * @Description：BdGlgxEnum 表单关联关系枚举
 */
@Getter
@AllArgsConstructor
public enum BdGlgxEnum {


    INNER("1"," INNER JOIN "),

    LEFT("2"," LEFT JOIN ");

    private String type;
    private String value;

    public static BdGlgxEnum getEnum(String type){
        BdGlgxEnum result = null;
        BdGlgxEnum[] enums = BdGlgxEnum.values();
        for (BdGlgxEnum enum_ : enums) {
            if (enum_.getType().equals(type)) {
                result = enum_;
                break;
            }
        }
        return result;
    }
}
