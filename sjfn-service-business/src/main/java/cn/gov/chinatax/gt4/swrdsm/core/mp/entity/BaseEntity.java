package cn.gov.chinatax.gt4.swrdsm.core.mp.entity;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import lombok.Data;
import org.apache.ibatis.type.JdbcType;

import java.io.Serializable;
import java.util.Date;

/**
 * @Copyright：Copyright (c) 2002-2023 Digitalchina CO.,LTD.  All rights reserved.
 * @Company：神州数码信息系统集成服务有限公司
 * @Department：税务地方大客户.CA
 * @Author：huax
 * @CreationTime：2023-11-22 15:58:00
 * @Version：1.0
 * @Compiler：1.8
 * @Description：BaseEntity
 */
@Data
public class BaseEntity implements Serializable {

    /* 录入人人代码*/
    @TableField(value = "lrr_dm",fill = FieldFill.INSERT, jdbcType = JdbcType.VARCHAR)
    private String lrrDm;

    /* 录入人人代码*/
    @TableField(value = "lrrswjg_dm",fill = FieldFill.INSERT, jdbcType = JdbcType.VARCHAR)
    private String lrrswjgDm;

    /* 录入时间 */
    @TableField(fill = FieldFill.INSERT)
    private Date lrsj;


    /* 录入人人代码*/
    @TableField(value = "xgr_dm",fill = FieldFill.INSERT_UPDATE, jdbcType = JdbcType.VARCHAR)
    private String xgrDm;

    /* 录入人人代码*/
    @TableField(value = "xgrswjg_dm",fill = FieldFill.INSERT_UPDATE, jdbcType = JdbcType.VARCHAR)
    private String xgrswjgDm;

    /* 录入时间 */
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Date xgsj;

}
