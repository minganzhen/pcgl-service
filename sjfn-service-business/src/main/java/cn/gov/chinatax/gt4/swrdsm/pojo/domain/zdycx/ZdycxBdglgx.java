package cn.gov.chinatax.gt4.swrdsm.pojo.domain.zdycx;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;


/**
 * 
 *
 * @author huax
 * @date 2023-11-22
 */
@Data
@TableName(value = "zdycx_bdglgx")
public class ZdycxBdglgx {
    /**
     * id 数开生成
     */
    @TableId(value = "id", type = IdType.ASSIGN_ID)
    private String id;
    /**
     * 表单1（左）
     */
    @TableField(value = "bd_dm1")
    private String bdDm1;

    /**
     * 表单2（右）
     */
    @TableField(value = "bd_dm2")
    private String bdDm2;

    /**
     * 关联条件展示、不加别名（DJHX=DJXH）
     */
    @TableField(value = "gltjmc")
    private String gltjmc;

    /**
     * 关联表单代码1
     */
    @TableField(value = "glzd_dm1")
    private String glzdDm1;

    /**
     * 关联表单代码2
     */
    @TableField(value = "glzd_dm2")
    private String glzdDm2;


    /**
     * Y/N
     */
    @TableField(value = "yxbz")
    private String yxbz;

}