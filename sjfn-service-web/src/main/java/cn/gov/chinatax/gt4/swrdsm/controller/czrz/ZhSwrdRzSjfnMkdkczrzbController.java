package cn.gov.chinatax.gt4.swrdsm.controller.czrz;

import cn.gov.chinatax.gt4.swrdsm.pojo.dto.czrz.ZhSwrdRzSjfnMkdkczrzbDto;
import cn.gov.chinatax.gt4.swrdsm.pojo.dto.czrz.ZhSwrdRzSjfnMkdkczrzbEditDto;
import cn.gov.chinatax.gt4.swrdsm.pojo.dto.czrz.ZhSwrdRzSjfnMkdkczrzbQueryDto;
import cn.gov.chinatax.gt4.swrdsm.service.czrz.ZhSwrdRzSjfnMkdkczrzbService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 接口
 *
 * @author huax
 * @date 2023-12-01
 */
@Api(tags = "操作日志 - 接口")
@RestController
@RequestMapping("/czrz")
public class ZhSwrdRzSjfnMkdkczrzbController {

    @Autowired
    private ZhSwrdRzSjfnMkdkczrzbService zhSwrdRzSjfnMkdkczrzbService;

    /**
     * 获取列表
     *
     * @param form
     * @return
     */
    @ApiOperation(value = "获取列表", response = ZhSwrdRzSjfnMkdkczrzbDto.class, responseContainer = "List")
    @GetMapping
    public List<ZhSwrdRzSjfnMkdkczrzbDto> getZhSwrdRzSjfnMkdkczrzbs(ZhSwrdRzSjfnMkdkczrzbQueryDto form) {
        return zhSwrdRzSjfnMkdkczrzbService.getZhSwrdRzSjfnMkdkczrzbs(form);
    }

    /**
     * 获取
     *
     * @param id
     * @return
     */
    @ApiOperation(value = "获取", response = ZhSwrdRzSjfnMkdkczrzbDto.class)
    @GetMapping("/detail")
    public ZhSwrdRzSjfnMkdkczrzbDto getZhSwrdRzSjfnMkdkczrzb(String id) {
        return zhSwrdRzSjfnMkdkczrzbService.getZhSwrdRzSjfnMkdkczrzb(id);
    }

    /**
     * 新增
     *
     * @param edit
     * @return
     */
    @ApiOperation(value = "新增", response = String.class)
    @PostMapping
    public String addZhSwrdRzSjfnMkdkczrzb(@RequestBody ZhSwrdRzSjfnMkdkczrzbEditDto edit) {
        return zhSwrdRzSjfnMkdkczrzbService.addZhSwrdRzSjfnMkdkczrzb(edit);
    }

    /**
     * 编辑
     *
     * @param edit
     * @return
     */
    @ApiOperation(value = "编辑", response = Boolean.class)
    @PutMapping
    public Boolean editZhSwrdRzSjfnMkdkczrzb(@RequestBody ZhSwrdRzSjfnMkdkczrzbEditDto edit) {
        return zhSwrdRzSjfnMkdkczrzbService.editZhSwrdRzSjfnMkdkczrzb(edit);
    }

    /**
     * 根据主键集合删除
     *
     * @param form
     * @return
     */
    @ApiOperation(value = "根据主键集合删除", response = Boolean.class)
    @DeleteMapping("/ids")
    public Boolean deleteZhSwrdRzSjfnMkdkczrzbs(@RequestBody ZhSwrdRzSjfnMkdkczrzbQueryDto form) {
        return zhSwrdRzSjfnMkdkczrzbService.deleteZhSwrdRzSjfnMkdkczrzbs(form);
    }
}