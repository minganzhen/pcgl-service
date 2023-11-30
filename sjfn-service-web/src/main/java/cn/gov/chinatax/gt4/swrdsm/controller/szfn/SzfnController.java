package cn.gov.chinatax.gt4.swrdsm.controller.szfn;

import cn.gov.chinatax.gt4.swrdsm.pojo.dto.szfn.SzfnZjjgDTO;
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
@Api(value = "数字赋能")
@RestController
@RequestMapping("/szfn")
public class SzfnController {

    @Resource
    private SzfnService szfnService;

    @ApiOperation(value = "数字赋能-查询业务办理提醒")
    @GetMapping("/v1/select-ywbltx")
    public ServerResponse<List<String>> selectYwbltx() {
        return ServerResponse.success(szfnService.selectYwbltx());
    }

    @ApiOperation(value = "数字赋能-智检结果")
    @GetMapping("/v1/select-zjjg")
    public ServerResponse<List<SzfnZjjgDTO>> selectZjjg() {
        return ServerResponse.success(szfnService.selectZjjg());
    }

    @ApiOperation(value = "数字赋能-易查")
    @GetMapping("/v1/select-yc")
    public ServerResponse<Map<String, Object>> selectYc(@RequestParam(value = "shtyxyDm") String shtyxyDm) {
        return ServerResponse.success(szfnService.selectYc(shtyxyDm));
    }


}
