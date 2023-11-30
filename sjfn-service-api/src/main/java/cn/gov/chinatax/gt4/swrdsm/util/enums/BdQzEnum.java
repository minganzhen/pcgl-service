package cn.gov.chinatax.gt4.swrdsm.util.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @Copyright：Copyright (c) 2002-2023 Digitalchina CO.,LTD.  All rights reserved.
 * @Company：神州数码信息系统集成服务有限公司
 * @Department：税务地方大客户.CA
 * @Author：huax
 * @CreationTime：2023-11-23 21:02:00
 * @Version：1.0
 * @Compiler：1.8
 * @Description：BdQzEnum 表单起止 改造成class处理
 */
@AllArgsConstructor
@Getter
public class BdQzEnum {
    private String lmDm;
    private String tjDm;
    private String fh;
    private String bdDm;

    public static BdQzEnum getEnum(List<BdQzEnum> list, String lmDm) {
        if (list == null) return null;
        List<BdQzEnum> collect = list.stream().filter(item -> Objects.equals(item.getLmDm(), lmDm)).collect(Collectors.toList());
        if (collect.isEmpty()) return null;
        return collect.get(0);
    }

    public StringBuilder buildWhereSql(Object value) {
        StringBuilder whereSql = new StringBuilder(" AND ");
        String zddm = this.bdDm + "." + this.tjDm;
        if (value instanceof Number) {
            whereSql.append(zddm).append(this.fh);
            whereSql.append(value).append(" ");
        } else {
            String format = "TO_CHAR( %s , 'yyyy-mm-dd')";
            whereSql.append(String.format(format,zddm)).append(this.fh);
            whereSql.append("'").append(value.toString()).append("' ");
        }
        return whereSql;
    }
}
