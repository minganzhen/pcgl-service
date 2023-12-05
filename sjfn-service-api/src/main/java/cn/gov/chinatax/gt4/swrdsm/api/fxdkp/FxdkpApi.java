package cn.gov.chinatax.gt4.swrdsm.api.fxdkp;

import cn.gov.chinatax.gt4.swrdsm.pojo.common.PageResultApi;
import cn.gov.chinatax.gt4.swrdsm.pojo.dto.fxdkp.FxdkpDto;
import cn.gov.chinatax.gt4.swrdsm.pojo.vo.fxdkp.FxdkpQueryDto;
import com.tencent.gov.goff.common.v2.pojo.bean.ServerResponse;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import javax.validation.Valid;

/**
 * @author zhaocn
 */

@Api(value = "风险点卡片")
@FeignClient(value = "sjfn-service", contextId = "FxdkpApi", path = "/sjfn/api/fxdkp")
public interface FxdkpApi {


    @ApiOperation(value = "风险点卡片-查询内控部门发送的风险点卡片")
    @PostMapping("/v1/select-fxdkp")
    public ServerResponse<PageResultApi<FxdkpDto>> selectFxdkp(@Valid @RequestBody FxdkpQueryDto form);


}
