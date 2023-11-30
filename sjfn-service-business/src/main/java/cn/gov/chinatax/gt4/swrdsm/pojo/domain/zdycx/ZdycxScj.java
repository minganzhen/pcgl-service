package cn.gov.chinatax.gt4.swrdsm.pojo.domain.zdycx;

import cn.gov.chinatax.gt4.swrdsm.core.mp.entity.BaseEntity;
import cn.gov.chinatax.gt4.swrdsm.pojo.dto.zdycx.ZdycxTjXsDto;
import cn.gov.chinatax.gt4.swrdsm.pojo.dto.zdycx.ZdycxZslDto;
import cn.gov.chinatax.gt4.swrdsm.util.core.KeyValue;
import com.baomidou.mybatisplus.annotation.*;
import com.baomidou.mybatisplus.extension.handlers.JacksonTypeHandler;
import lombok.Data;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @author huax
 * @date 2023-11-22
 */
@Data
@TableName(value = "zdycx_scj", autoResultMap = true)
public class ZdycxScj extends BaseEntity {
    /**
     * 主键id
     */
    @TableId(value = "id", type = IdType.ASSIGN_ID)
    private String id;

    /**
     * 表单代码名称（，分割）
     */
    @TableField(value = "bd_dms", typeHandler = JacksonTypeHandler.class)
    private List<KeyValue<String, String>> bdDms;

    /**
     * 表单关联关系类型（1: inner、2: left ）
     */
    @TableField(value = "bd_glgx_lx")
    private String bdGlgxLx;

    /**
     * 表单关联关系（存储关联关系的id,使用，分隔）冗余字段，方便扩展
     */
    @TableField(value = "bd_glgxs", typeHandler = JacksonTypeHandler.class)
    private List<String> bdGlgxs;

    /**
     * 表单可选条件结果集合[]-> 存储列名即可
     */
    @TableField(value = "bd_kxtj_label",typeHandler = JacksonTypeHandler.class)
    private Map<String,List<ZdycxTjXsDto>> bdKxtjLabel;

    /**
     * 表单可选条件值为 lm_key和value的map集合
     */
    @TableField(value = "bd_kxtj_value",typeHandler = JacksonTypeHandler.class)
    private Map<String,Object> bdKxtjValue;

    /**
     * 模糊查询，按行解析数据、{"value":[{"key":0,"xh":1,"djxh":"10116301000038367942"}]}
     */
    @TableField(value = "bd_mhtj")
    private String bdMhtj;

    /**
     * 表单展示列,使用map形式封装，key为表单号，值为当前选的列名集合,bmas为别名[A、B、C]，{id,lm_dm,lm_mc,bmas,px}
     */
    @TableField(value = "bd_zsls",typeHandler = JacksonTypeHandler.class)
    private Map<String,List<ZdycxZslDto>> bdZsls;

    /**
     * 收藏名称
     */
    @TableField(value = "scmc")
    private String scmc;

    /**
     * Y/N
     */
    @TableField(value = "yxbz")
    private String yxbz;

}