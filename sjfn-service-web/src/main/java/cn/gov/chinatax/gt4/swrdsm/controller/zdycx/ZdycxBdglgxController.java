package cn.gov.chinatax.gt4.swrdsm.controller.zdycx;

import java.util.List;

import cn.gov.chinatax.gt4.swrdsm.pojo.dto.zdycx.ZdycxBdglgxDto;
import cn.gov.chinatax.gt4.swrdsm.pojo.dto.zdycx.ZdycxBdglgxQueryDto;
import cn.gov.chinatax.gt4.swrdsm.service.zdycx.ZdycxBdglgxService;
import com.tencent.gov.goff.common.v2.pojo.bean.ServerResponse;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * 接口
 *
 * @author huax
 * @date 2023-11-22
 */
@Api(tags = "自定义查询-表单关系接口")
@RestController
@RequestMapping("/zdycx-bdglgx")
public class ZdycxBdglgxController {

    @Autowired
    private ZdycxBdglgxService zdycxBdglgxService;

	/**
     * 获取列表
     *
     * @param form
     * @return
     */
    @ApiOperation(value = "获取表单关系")
    @GetMapping("/v1/select-gx")
    public ServerResponse<List<ZdycxBdglgxDto>> getZdycxBdglgxs(@Valid ZdycxBdglgxQueryDto form) {
        return ServerResponse.success(zdycxBdglgxService.getZdycxBdglgxs(form));
    }

    /**
     * 获取主题之间是否存在关联关系
     *
     * @return
     */
    @ApiOperation(value = "获取主题之间是否存在关联关系")
    @GetMapping("/v1/select-sfczgx")
    public ServerResponse<Boolean> selectSfczgx(@Valid ZdycxBdglgxQueryDto form) {
        return ServerResponse.success(zdycxBdglgxService.selectSfczgx(form));
    }
    
}