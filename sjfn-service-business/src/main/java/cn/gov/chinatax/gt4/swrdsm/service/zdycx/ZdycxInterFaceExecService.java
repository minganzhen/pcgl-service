package cn.gov.chinatax.gt4.swrdsm.service.zdycx;

import cn.gov.chinatax.gt4.swrdsm.pojo.vo.zdycx.ZdycxMxcxQueryDto;
import cn.gov.chinatax.gt4.swrdsm.pojo.vo.zdycx.ZdycxTjcxQueryDto;

import java.util.Map;

/**
 * @Copyright：Copyright (c) 2002-2023 Digitalchina CO.,LTD.  All rights reserved.
 * @Company：神州数码信息系统集成服务有限公司
 * @Department：税务地方大客户.CA
 * @Author：huax
 * @CreationTime：2023-11-28 10:57:00
 * @Version：1.0
 * @Compiler：1.8
 * @Description：ZdycxInterFaceExecService 接口定义
 */
public interface ZdycxInterFaceExecService {

    Map<String, Object> selectMxcx(ZdycxMxcxQueryDto queryDto);

    Map<String, Object> selectTjcx(ZdycxTjcxQueryDto queryDto);
}
