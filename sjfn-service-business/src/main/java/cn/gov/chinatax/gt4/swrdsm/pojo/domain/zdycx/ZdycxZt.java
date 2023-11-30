package cn.gov.chinatax.gt4.swrdsm.pojo.domain.zdycx;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;


/**
 *  自定义查询主题
 *
 * @author huax
 * @date 2023-11-21
 */
@TableName(value = "zdycx_zt")
@Data
public class ZdycxZt {
	/**
	 * 上级主题代码
	 */
	@TableField(value = "sj_dm")
	private String sjDm;

	/**
	 * Y/N
	 */
	@TableField(value = "yxbz")
	private String yxbz;

	/**
	 * 主题代码
	 */
	@TableId(value = "zt_dm", type = IdType.ASSIGN_ID)
	private String ztDm;

	/**
	 * 主题级次
	 */
	@TableField(value = "zt_jc")
	private String ztJc;

	/**
	 * 主题名称
	 */
	@TableField(value = "ztmc")
	private String ztmc;

}