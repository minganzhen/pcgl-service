package cn.gov.chinatax.gt4.swrdsm.pojo.dto.zdycx;

import cn.gov.chinatax.gt4.swrdsm.util.core.KeyValue;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Data
@ApiModel(value = "自定义查询收藏夹")
public class ZdycxScjDto implements Serializable {

    /**
     * 主键id
     */
    @ApiModelProperty(value = "主键id")
    private String id;

    /**
     * 收藏名称
     */
    @ApiModelProperty(value = "收藏名称")
    @NotNull(message = "收藏名称不能为空")
    private String scmc;

    /**
     * 表单代码名称（，分割）
     */
    @ApiModelProperty(value = "表单代码名称 [key 为 表单号 value 为表名]")
    @NotEmpty(message = "表单代码名称不能为空")
    private List<KeyValue<String,String>> bdDms;

    /**
     * 表单关联关系类型（1: inner、2: left ）
     */
    @ApiModelProperty(value = "表单关联关系类型（1: inner、2: left ）")
    @NotEmpty(message = "表单关联关系类型不能为空")
    private String bdGlgxLx;

    /**
     * 表单关联关系（存储关联关系的id,使用，分隔）冗余字段，方便扩展
     */
    @ApiModelProperty(value = "表单关联关系（存储关联关系的id,使用，分隔）冗余字段，方便扩展")
    private List<String> bdGlgxs;

    /**
     * 表单可选 + 预选数据条件结果集合[]-> 存储列名即可
     */
    @ApiModelProperty(value = "表单可选条件结果集合[]-> 存储列名即可")
    @NotEmpty(message = "表单可选条件结果集合不能为空")
    private Map<String,List<ZdycxTjXsDto>> bdKxtjLabel;

    /**
     * 表单可选条件值为 lm_key和value的map集合
     */
    @ApiModelProperty(value = "表单可选条件值为 lm_key和value的map集合")
    @NotEmpty(message = "表单可选条件不能为空")
    private Map<String,Object> bdKxtjValue;

    /**
     * 模糊查询，按行解析数据、{"value":[{"key":0,"xh":1,"djxh":"10116301000038367942"}]}
     */
    @ApiModelProperty(value = "模糊查询，按行解析数据")
    private String bdMhtj;

    /**
     * 表单展示列,使用map形式封装，key为表单号 值选中的数据结果
     */
    @ApiModelProperty(value = "表单展示列")
    @NotEmpty(message = "表单展示列不能为空")
    private Map<String,List<ZdycxZslDto>> bdZsls;

    /* 录入机关*/
    private String lrrDm;

    /* 录入人机关*/
    private String lrrswjgDm;

    /* 录入时间 */
    private Date lrsj;


    /* 录入人人代码*/
    private String xgrDm;

    /* 修改人机关*/
    private String xgrswjgDm;

    /* 录入时间 */
    private Date xgsj;

    /**
     * Y/N
     */
    @ApiModelProperty(value = "表单展示列")
    private String yxbz;
}