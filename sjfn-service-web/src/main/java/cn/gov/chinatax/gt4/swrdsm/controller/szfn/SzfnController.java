package cn.gov.chinatax.gt4.swrdsm.controller.szfn;

import cn.gov.chinatax.gt4.swrdsm.pojo.dto.szfn.SzfnHkHbPzDto;
import cn.gov.chinatax.gt4.swrdsm.pojo.dto.szfn.SzfnZjjgDto;
import cn.gov.chinatax.gt4.swrdsm.pojo.dto.szfn.ZhSwrdCsSjfnYwtxnrcsbDto;
import cn.gov.chinatax.gt4.swrdsm.service.szfn.SzfnService;
import com.tencent.gov.goff.common.v2.pojo.bean.ServerResponse;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
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
@Api(value = "数据赋能 - 接口")
@RestController
@RequestMapping("/szfn")
public class SzfnController {

    @Resource
    private SzfnService szfnService;

    @ApiOperation(value = "数据赋能-小贴士")
    @GetMapping("/v1/select-ywbltx")
    public ServerResponse<ZhSwrdCsSjfnYwtxnrcsbDto> selectYwbltx(@RequestParam(value = "gnbs") String gnbs) {
        return ServerResponse.success(szfnService.selectYwbltx(gnbs));
    }

    @ApiOperation(value = "数据赋能-慧办/小红点")
    @GetMapping("/v1/select-zjjg")
    public ServerResponse<List<SzfnZjjgDto>> selectZjjg(@RequestParam(value = "llrsfid", required = false) String llrsfid) {
        return ServerResponse.success(szfnService.selectZjjg(llrsfid));
    }

    @ApiOperation(value = "数据赋能-慧看")
    @GetMapping("/v1/select-yc")
    public ServerResponse<Map<String, Object>> selectYc(@RequestParam(value = "shtyxyDm") String shtyxyDm) {
        return ServerResponse.success(szfnService.selectYc(shtyxyDm));
    }

    @ApiOperation(value = "数据赋能-慧看/慧办按钮显示")
    @GetMapping("/v1/select-hkandhb")
    public ServerResponse<Map<String, Boolean>> selectHkAndHb(@RequestParam(value = "ywblmc") String ywblmc) {
        return ServerResponse.success(szfnService.selectHkAndHb(ywblmc));
    }

    @ApiOperation(value = "数据赋能-慧看/慧办按钮显示 v2版本")
    @GetMapping("/v2/select-hkandhb")
    public ServerResponse<List<SzfnHkHbPzDto>> selectV2HkAndHb() {
        return ServerResponse.success(szfnService.selectV2HkAndHb());
    }


}
