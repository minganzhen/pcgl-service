package cn.gov.chinatax.gt4.swrdsm.controller.zdycx;

import cn.gov.chinatax.gt4.swrdsm.pojo.vo.zdycx.ZdycxMxcxQueryDto;
import cn.gov.chinatax.gt4.swrdsm.pojo.vo.zdycx.ZdycxTjcxQueryDto;
import cn.gov.chinatax.gt4.swrdsm.service.zdycx.ZdycxExecService;
import com.tencent.gov.goff.common.v2.pojo.bean.ServerResponse;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.validation.Valid;
import java.util.Map;

/**
 * 自定义查询 - 执行统计查询接口
 *
 * @author huax
 * @date 2023-11-21
 */
@Api(tags = "自定义查询 - 执行统计查询接口")
@RestController
@RequestMapping("/zdycx-exec")
public class ZdycxExecController {

    @Resource
    private ZdycxExecService zdycxExecService;
	/**
     * 查询执行器
     *
     * @return
     */
    @ApiOperation(value = "明细查询")
    @PostMapping("/v1/select-mxcx")
    public ServerResponse<Map<String,Object>> selectMxcx(@Valid @RequestBody ZdycxMxcxQueryDto queryDto) {
        return ServerResponse.success(zdycxExecService.selectMxcx(queryDto));
    }
	/**
     * 查询执行器
     *
     * @return
     */
    @ApiOperation(value = "统计分析")
    @PostMapping("/v1/select-tjcx")
    public ServerResponse<Map<String,Object>> selectTjcx(@Valid @RequestBody ZdycxTjcxQueryDto queryDto) {
        return ServerResponse.success(zdycxExecService.selectTjcx(queryDto));
    }




}