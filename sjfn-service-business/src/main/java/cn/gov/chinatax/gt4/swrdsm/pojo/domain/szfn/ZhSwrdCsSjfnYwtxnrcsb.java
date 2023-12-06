package cn.gov.chinatax.gt4.swrdsm.pojo.domain.szfn;

import cn.gov.chinatax.gt4.swrdsm.core.mp.entity.BaseEntity;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * @author huax
 * @date 2023-12-01
 */
@Data
@TableName(value = "CS_ZH_SJFN_YWTXNRCSB")
public class ZhSwrdCsSjfnYwtxnrcsb extends BaseEntity {

    /**
     * 业务提醒内容参数主键ID
     */
    @TableId(value = "YWTXNRCSZJUUID", type = IdType.ASSIGN_ID)
    private String ywtxnrcszjuuid;

    /**
     * 税务机关代码
     */
    @TableField(value = "SWJG_DM")
    private String swjgDm;

    /**
     * 提醒标题
     */
    @TableField(value = "TXBT")
    private String txbt;

    /**
     * 提醒内容
     */
    @TableField(value = "HSTXNR")
    private String hstxnr;
    /**
     * 功能标识
     */
    @TableField(value = "gnbs")
    private String gnbs;
}