package cn.gov.chinatax.gt4.swrdsm.controller.zdycx;

import cn.gov.chinatax.gt4.swrdsm.core.mp.page.PageResult;
import cn.gov.chinatax.gt4.swrdsm.pojo.dto.zdycx.ZdycxScjDto;
import cn.gov.chinatax.gt4.swrdsm.pojo.dto.zdycx.ZdycxScjEditDto;
import cn.gov.chinatax.gt4.swrdsm.pojo.dto.zdycx.ZdycxScjQueryDto;
import cn.gov.chinatax.gt4.swrdsm.service.zdycx.ZdycxScjService;
import com.tencent.gov.goff.common.v2.pojo.bean.ServerResponse;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * 接口
 *
 * @author huax
 * @date 2023-11-22
 */
@Api(tags = "自定义查询- 收藏夹接口")
@RestController
@RequestMapping("/zdycx-scj")
public class ZdycxScjController {

    @Autowired
    private ZdycxScjService zdycxScjService;

    /**
     * 获取列表
     *
     * @param form
     * @return
     */
    @ApiOperation(value = "获取收藏夹列表", response = ZdycxScjDto.class, responseContainer = "List")
    @GetMapping("/v1/select-page")
    public ServerResponse<PageResult<ZdycxScjDto>> getZdycxScjs(ZdycxScjQueryDto form) {
        return ServerResponse.success(zdycxScjService.getZdycxScjs(form));
    }

    /**
     * 获取
     *
     * @param id
     * @return
     */
    @ApiOperation(value = "获取单个收藏夹", response = ZdycxScjDto.class)
    @GetMapping("/v1/detail")
    public ServerResponse<ZdycxScjDto> getZdycxScj(@RequestParam(value = "id") String id) {
        return ServerResponse.success(zdycxScjService.getZdycxScj(id));
    }

    /**
     * 新增
     *
     * @param edit
     * @return
     */
    @ApiOperation(value = "新增收藏夹", response = String.class)
    @PostMapping("/v1/add")
    public ServerResponse<String> addZdycxScj(@Valid @RequestBody ZdycxScjEditDto edit) {
        return ServerResponse.success(zdycxScjService.addZdycxScj(edit));
    }

    /**
     * 根据主键集合删除
     *
     * @return
     */
    @ApiOperation(value = "根据主键集合删除", response = Boolean.class)
    @DeleteMapping("/v1/delete-ids")
    public ServerResponse<Boolean> deleteZdycxScjs(@RequestBody List<String> ids) {
        return ServerResponse.success(zdycxScjService.deleteZdycxScjs(ids));
    }
}