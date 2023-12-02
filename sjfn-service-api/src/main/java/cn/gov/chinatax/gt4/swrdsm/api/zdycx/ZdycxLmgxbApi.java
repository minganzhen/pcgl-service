package cn.gov.chinatax.gt4.swrdsm.api.zdycx;

import cn.gov.chinatax.gt4.swrdsm.pojo.dto.zdycx.ZdycxLmgxbQueryDto;
import cn.gov.chinatax.gt4.swrdsm.pojo.dto.zdycx.ZdycxTjXsDto;
import cn.gov.chinatax.gt4.swrdsm.pojo.dto.zdycx.ZdycxZslDto;
import cn.gov.chinatax.gt4.swrdsm.pojo.vo.zdycx.ZdycxTjFxBeforeQueryDto;
import com.tencent.gov.goff.common.v2.pojo.bean.ServerResponse;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import javax.validation.Valid;
import java.util.List;
import java.util.Map;

/**
 * 接口
 *
 * @author huax
 * @date 2023-11-22
 */
@Api(tags = "自定义查询 - 列名接口")
@FeignClient(value = "swrdsm-service", contextId = "ZdycxLmgxbApi", path = "/sjfn/api/zdycx-lmgxb")
public interface ZdycxLmgxbApi {

    /**
     * 获取结果列和排序定制数据
     *
     * @param form
     * @return
     */
    @ApiOperation(value = "获取列名列表")
    @GetMapping("/v1/select-lm")
    public ServerResponse<Map<String, List<ZdycxZslDto>>> selectLm(@Valid ZdycxLmgxbQueryDto form);

    /**
     * 获取选中的条件
     *
     * @param form
     * @return
     */
    @ApiOperation(value = "获取选中的条件")
    @GetMapping("/v1/select-tj")
    public ServerResponse<Map<String, List<ZdycxTjXsDto>>> selectTj(@Valid ZdycxLmgxbQueryDto form);

    /**
     *  获取分组字段、统计字段、可以选择的对比方式
     *
     * @param queryDto
     * @return
     */
    @ApiOperation(value = "获取分组字段、统计字段")
    @PostMapping("/v1/select-tjfx")
    public ServerResponse<Map<String, Object>> selectTjfx(@RequestBody ZdycxTjFxBeforeQueryDto queryDto);
}