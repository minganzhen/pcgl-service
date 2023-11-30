package cn.gov.chinatax.gt4.swrdsm.api.zdycx;

import cn.gov.chinatax.gt4.swrdsm.pojo.dto.zdycx.ZdycxBdglgxDto;
import cn.gov.chinatax.gt4.swrdsm.pojo.dto.zdycx.ZdycxBdglgxQueryDto;
import com.tencent.gov.goff.common.v2.pojo.bean.ServerResponse;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import javax.validation.Valid;
import java.util.List;

/**
 * 接口
 *
 * @author huax
 * @date 2023-11-22
 */
@Api(tags = "自定义查询-表单关系接口")
@FeignClient(value = "swrdsm-service", contextId = "ZdycxBdglgxApi", path = "/swrdsm-api/zdycx-bdglgx")
public interface ZdycxBdglgxApi {

    /**
     * 获取列表
     *
     * @param form
     * @return
     */
    @ApiOperation(value = "获取表单关系")
    @GetMapping("/v1/select-gx")
    public ServerResponse<List<ZdycxBdglgxDto>> getZdycxBdglgxs(@Valid ZdycxBdglgxQueryDto form);

    /**
     * 获取主题之间是否存在关联关系
     *
     * @return
     */
    @ApiOperation(value = "获取主题之间是否存在关联关系")
    @GetMapping("/v1/select-sfczgx")
    public ServerResponse<Boolean> selectSfczgx(@Valid ZdycxBdglgxQueryDto form);

}