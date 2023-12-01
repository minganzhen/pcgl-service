package cn.gov.chinatax.gt4.swrdsm.pojo.dto.zdycx;

import com.tencent.gov.goff.common.v2.pojo.bean.QueryParam;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

@Data
@ApiModel(value = "自定义查询收藏夹查询条件")
public class ZdycxScjQueryDto extends QueryParam {

    /**
     * 主键id
     */
    @ApiModelProperty(value = "主键id")
    private String id;

    /**
     * 收藏名称
     */
    @ApiModelProperty(value = "收藏名称")
    private String scmc;

    /**
     * 录入日期
     */
    private Date lrrq;

    /**
     * 录入人身份ID
     */
    private String lrrsfid;
    /**
     * 修改日期
     */
    private Date xgrq;

    /**
     * 修改人身份ID
     */
    private String xgrsfid;

}