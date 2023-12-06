package cn.gov.chinatax.gt4.swrdsm.pojo.domain.czrz;

import cn.gov.chinatax.gt4.swrdsm.core.mp.entity.BaseEntity;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.Date;

/**
 * 
 *
 * @author huax
 * @date 2023-12-01
 */
@Data
@TableName(value = "CS_ZH_SJFN_MKDKCZRZB")
public class ZhSwrdRzSjfnMkdkczrzb extends BaseEntity {

    /**
     * 模块打开操作参数主键ID
     */
    @TableId(value = "MKDKCZCSZJUUID", type = IdType.ASSIGN_ID)
    private String mkdkczcszjuuid;

    /**
     * 标题名称
     */
    @TableField(value = "BTMC")
    private String btmc;

    /**
     * 操作时间
     */
    @TableField(value = "CZSJ")
    private Date czsj;

    /**
     * 功能标识
     */
    @TableField(value = "GNBS")
    private String gnbs;

}