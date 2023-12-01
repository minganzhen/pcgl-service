package cn.gov.chinatax.gt4.swrdsm.core.util;


/**
 * @Copyright：Copyright (c) 2002-2023 Digitalchina CO.,LTD.  All rights reserved.
 * @Company：神州数码信息系统集成服务有限公司
 * @Department：税务地方大客户.CA
 * @Author：huax
 * @CreationTime：2023-11-28 10:59:00
 * @Version：1.0
 * @Compiler：1.8
 * @Description：SqlExecUtil sql拼接util
 */
public class SqlExecJoinUtil {

    public static final String NULL_STR = " ";
    public static final String EQUAL = " = ";
    public static final String GT = " >= ";
    public static final String LT = " <= ";
    public static final String IN = " IN ";
    public static final String AND = " AND ";
    public static final String AS = " AS ";
    public static final String ON = " ON ";
    public static final String DIAN = ".";
    public static final String DYH = "'";
    public static final String DOU_HAO = ",";

    public static final String CONCAT_THB = " CASE WHEN %s = 0 THEN 0 ELSE CONCAT(ROUND( %s / %s * 100, 2), '%s') END %s";
    public static final String TO_CHAR_RQ = "TO_CHAR( %s , 'yyyy-mm-dd') ";

    public static final String Q = "q";
    public static final String Z = "z";
    private static final String DYH_STR = " '%s' ";
    private static final String DIAN_STR = " %s.%s ";
    /**
     * 将值格式化带上单引号
     *
     * @param value
     * @return
     */
    public static String getDyhStr(Object value) {
        return String.format(DYH_STR, value.toString());
    }


    public static String getTableDianStr(String bmmc, String zdmc) {
        return String.format(DIAN_STR, bmmc, zdmc);
    }
    public static String getQStr(String lmDm) {
        return lmDm + Q;
    }
    public static String getZStr(String lmDm) {
        return lmDm + Z;
    }


}
