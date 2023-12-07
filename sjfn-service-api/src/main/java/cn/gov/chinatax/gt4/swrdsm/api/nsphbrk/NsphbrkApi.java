package cn.gov.chinatax.gt4.swrdsm.api.nsphbrk;

import cn.gov.chinatax.gt4.swrdsm.pojo.dto.nsphbrk.NsphbrkDto;
import cn.gov.chinatax.gt4.swrdsm.pojo.vo.nsphbrk.NsphbrkQueryDto;
import com.tencent.gov.goff.common.v2.pojo.bean.ServerResponse;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import javax.validation.Valid;
import java.util.List;

/**
 * @author zhaocn
 */

@Api(value = "纳税排行榜入库")
@FeignClient(value = "sjfn-service", contextId = "NsphbrkApi", path = "/sjfn/api/nsphbrk")
public interface NsphbrkApi {


    @ApiOperation(value = "风险点卡片-纳税排行榜入库")
    @PostMapping("/v1/select-nsphbrk")
    public ServerResponse<List<NsphbrkDto>> selectNsphbrk(@Valid @RequestBody NsphbrkQueryDto form);


}
