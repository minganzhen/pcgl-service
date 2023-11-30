package cn.gov.chinatax.gt4.swrdsm.util.enums;

import com.tencent.gov.goff.common.v2.pojo.bean.IErrorCode;

/**
 * 税务人端 ErrorCode
 *
 * @author huax
 */
public enum SwrdsmErrorCode implements IErrorCode {

    BIZ_ADD_FAIL("400", "新增失败"),
    BIZ_DELEE_FAIL("400", "删除失败");

    private String code;
    private String desc;

    SwrdsmErrorCode(String code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public String getCode() {
        return this.code;
    }

    public String getDesc() {
        return this.desc;
    }
}
