package cn.gov.chinatax.gt4.swrdsm.controller.zdycx;

import cn.gov.chinatax.gt4.swrdsm.pojo.dto.zdycx.ZdycxLmgxbQueryDto;
import cn.gov.chinatax.gt4.swrdsm.pojo.dto.zdycx.ZdycxTjXsDto;
import cn.gov.chinatax.gt4.swrdsm.pojo.dto.zdycx.ZdycxZslDto;
import cn.gov.chinatax.gt4.swrdsm.pojo.vo.zdycx.ZdycxTjFxBeforeQueryDto;
import cn.gov.chinatax.gt4.swrdsm.service.zdycx.ZdycxLmgxbService;
import com.tencent.gov.goff.common.v2.pojo.bean.ServerResponse;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
@RestController
@RequestMapping("/zdycx-lmgxb")
public class ZdycxLmgxbController {

    @Autowired
    private ZdycxLmgxbService zdycxLmgxbService;

    /**
     * 获取结果列和排序定制数据
     *
     * @param form
     * @return
     */
    @ApiOperation(value = "获取列名列表")
    @PostMapping("/v1/select-lm")
    public ServerResponse<Map<String, List<ZdycxZslDto>>> selectLm(@Valid @RequestBody ZdycxLmgxbQueryDto form) {
        return ServerResponse.success(zdycxLmgxbService.selectLm(form));
    }

    /**
     * 获取选中的条件
     *
     * @param form
     * @return
     */
    @ApiOperation(value = "获取选中的条件")
    @PostMapping("/v1/select-tj")
    public ServerResponse<Map<String, List<ZdycxTjXsDto>>> selectTj(@Valid @RequestBody ZdycxLmgxbQueryDto form) {
        return ServerResponse.success(zdycxLmgxbService.selectTj(form));
    }

    /**
     * 获取分组字段、统计字段、可以选择的对比方式
     *
     * @param queryDto
     * @return
     */
    @ApiOperation(value = "获取分组字段、统计字段")
    @PostMapping("/v1/select-tjfx")
    public ServerResponse<Map<String, Object>> selectTjfx(@Valid @RequestBody ZdycxTjFxBeforeQueryDto queryDto) {
        return ServerResponse.success(zdycxLmgxbService.selectTjfx(queryDto));
    }
}