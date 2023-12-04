package cn.gov.chinatax.gt4.swrdsm.controller.fxdkp;

import cn.gov.chinatax.gt4.swrdsm.core.mp.page.PageResult;
import cn.gov.chinatax.gt4.swrdsm.pojo.common.PageResultApi;
import cn.gov.chinatax.gt4.swrdsm.pojo.dto.fxdkp.FxdkpDto;
import cn.gov.chinatax.gt4.swrdsm.pojo.vo.fxdkp.FxdkpQueryDto;
import cn.gov.chinatax.gt4.swrdsm.service.fxdkp.FxdkpService;
import com.tencent.gov.goff.common.v2.pojo.bean.ServerResponse;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.validation.Valid;

/**
 * @author zhaocn
 */

@Api(value = "风险点卡片")
@RestController
@RequestMapping("/fxdkp")
public class FxdkpController {

    @Resource
    private FxdkpService fxdkpService;

    @ApiOperation(value = "风险点卡片-查询内控部门发送的风险点卡片")
    @GetMapping("/v1/select-fxdkp")
    public ServerResponse<PageResultApi<FxdkpDto>> selectFxdkp(@Valid FxdkpQueryDto form) {
        return ServerResponse.success(fxdkpService.selectFxdkp(form));
    }


}
