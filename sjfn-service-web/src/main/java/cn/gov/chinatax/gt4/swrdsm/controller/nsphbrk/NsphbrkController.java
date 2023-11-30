package cn.gov.chinatax.gt4.swrdsm.controller.nsphbrk;

import cn.gov.chinatax.gt4.swrdsm.pojo.dto.nsphbrk.NsphbrkDto;
import cn.gov.chinatax.gt4.swrdsm.pojo.vo.nsphbrk.NsphbrkQueryDto;
import cn.gov.chinatax.gt4.swrdsm.service.nsphbrk.NsphbrkService;
import com.tencent.gov.goff.common.v2.pojo.bean.ServerResponse;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.validation.Valid;
import java.util.List;

/**
 * @author zhaocn
 */

@Api(value = "纳税排行榜入库")
@RestController
@RequestMapping("/nsphbrk")
public class NsphbrkController {

    @Resource
    private NsphbrkService nsphbrkService;

    @ApiOperation(value = "风险点卡片-查询内控部门发送的风险点卡片")
    @GetMapping("/v1/select-nsphbrk")
    public ServerResponse<List<NsphbrkDto>> selectNsphbrk(@Valid NsphbrkQueryDto form) {
        return ServerResponse.success(nsphbrkService.selectNsphbrk(form));
    }


}
