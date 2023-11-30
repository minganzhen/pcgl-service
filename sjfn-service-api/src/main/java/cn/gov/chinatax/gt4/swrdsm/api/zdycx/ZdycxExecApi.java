package cn.gov.chinatax.gt4.swrdsm.api.zdycx;

import cn.gov.chinatax.gt4.swrdsm.pojo.vo.zdycx.ZdycxMxcxQueryDto;
import cn.gov.chinatax.gt4.swrdsm.pojo.vo.zdycx.ZdycxTjcxQueryDto;
import com.tencent.gov.goff.common.v2.pojo.bean.ServerResponse;
import io.swagger.annotations.Api;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import javax.validation.Valid;
import java.util.Map;
@Api(tags = "自定义查询 - 执行统计查询接口")
@FeignClient(value = "swrdsm-service", contextId = "ZdycxExecApi", path = "/swrdsm-api/zdycx-exec")
public interface ZdycxExecApi {

    /**
     * 自定义明细查询
     * @param queryDto
     * @return
     */
    @PostMapping("/v1/select-mxcx")
    public ServerResponse<Map<String,Object>> selectMxcx(@Valid @RequestBody ZdycxMxcxQueryDto queryDto);

    /**
     * 自定义统计查询
     * @param queryDto
     * @return
     */
    @PostMapping("/v1/select-tjcx")
    public ServerResponse<Map<String,Object>> selectTjcx(@Valid @RequestBody ZdycxTjcxQueryDto queryDto);
}