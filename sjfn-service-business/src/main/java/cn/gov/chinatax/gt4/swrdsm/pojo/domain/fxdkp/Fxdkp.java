package cn.gov.chinatax.gt4.swrdsm.pojo.domain.fxdkp;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;


/**
 * 
 *
 * @author zhaocn
 * @date 2023-11-22
 */
@Data
@TableName(value = "SWRD_HCLC_KP")
public class Fxdkp {
    /**
     * id 核查流程卡片uuid
     */
    @TableId(value = "HCLC_KP_UUID", type = IdType.ASSIGN_ID)
    private String hclcKpUuid;
    /**
     * 接受月份
     */
    @TableField(value = "JSYF")
    private String jsyf;

    /**
     * 核查单位
     */
    @TableField(value = "HCDW")
    private String hcdw;

    /**
     * 疑点总数
     */
    @TableField(value = "YDZS")
    private String ydzs;

    /**
     * 已核查疑点数
     */
    @TableField(value = "YHCYDS")
    private String yhcyds;

    /**
     * 未核查疑点数
     */
    @TableField(value = "WHCYDS")
    private String whcyds;


    /**
     * Y/N
     */
    @TableField(value = "有效标志")
    private String yxbz;

}