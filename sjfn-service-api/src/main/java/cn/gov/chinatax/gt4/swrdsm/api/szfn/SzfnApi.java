package cn.gov.chinatax.gt4.swrdsm.api.szfn;

import cn.gov.chinatax.gt4.swrdsm.pojo.dto.szfn.SzfnHkHbPzDto;
import cn.gov.chinatax.gt4.swrdsm.pojo.dto.szfn.SzfnHkHbPzDtoV3;
import cn.gov.chinatax.gt4.swrdsm.pojo.dto.szfn.SzfnZjjgDto;
import cn.gov.chinatax.gt4.swrdsm.pojo.dto.szfn.ZhSwrdCsSjfnYwtxnrcsbDto;
import com.tencent.gov.goff.common.v2.pojo.bean.ServerResponse;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Map;

/**
 * @Copyright：Copyright (c) 2002-2023 Digitalchina CO.,LTD.  All rights reserved.
 * @Company：神州数码信息系统集成服务有限公司
 * @Department：税务地方大客户.CA
 * @Author：huax
 * @CreationTime：2023-11-15 10:12:00
 * @Version：1.0
 * @Compiler：1.8
 * @Description：数字赋能接口
 */
@Api(value = "数字赋能")
@FeignClient(value = "swrdsm-service", contextId = "SzfnApi", path = "/sjfn/api/szfn")
public interface SzfnApi {


    @ApiOperation(value = "数字赋能-小贴士")
    @GetMapping("/v1/select-ywbltx")
    public ServerResponse<ZhSwrdCsSjfnYwtxnrcsbDto> selectYwbltx(@RequestParam(value = "gnbs") String gnbs);

    @ApiOperation(value = "数字赋能-慧办/小红点")
    @GetMapping("/v1/select-zjjg")
    public ServerResponse<List<SzfnZjjgDto>> selectZjjg(@RequestParam(value = "llrsfid") String llrsfid);

    @ApiOperation(value = "数字赋能-慧看")
    @GetMapping("/v1/select-yc")
    public ServerResponse<Map<String, Object>> selectYc(@RequestParam(value = "shtyxyDm") String shtyxyDm);

    @ApiOperation(value = "数字赋能-慧看/慧办按钮显示")
    @GetMapping("/v3/select-hkandhb")
    public ServerResponse<List<SzfnHkHbPzDtoV3>> selectV3HkAndHb();
}
