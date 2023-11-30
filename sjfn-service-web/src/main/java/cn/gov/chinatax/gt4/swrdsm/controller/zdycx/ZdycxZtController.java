package cn.gov.chinatax.gt4.swrdsm.controller.zdycx;

import java.util.List;

import cn.gov.chinatax.gt4.swrdsm.pojo.dto.zdycx.ZdycxZtDto;
import cn.gov.chinatax.gt4.swrdsm.pojo.dto.zdycx.ZdycxZtTree;
import cn.gov.chinatax.gt4.swrdsm.service.zdycx.ZdycxZtService;
import cn.hutool.core.lang.tree.Tree;
import cn.hutool.core.lang.tree.TreeNodeConfig;
import cn.hutool.core.lang.tree.TreeUtil;
import cn.hutool.core.util.ObjectUtil;
import com.tencent.gov.goff.common.v2.pojo.bean.ServerResponse;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * 自定义查询主题
 *
 * @author huax
 * @date 2023-11-21
 */
@Api(tags = "自定义查询 - 主题接口")
@RestController
@RequestMapping("/zdycx-zt")
public class ZdycxZtController {

    @Autowired
    private ZdycxZtService zdycxZtService;

    /**
     * 获取主题树
     *
     * @return
     */
    @ApiOperation(value = "获取主题-tree", response = ZdycxZtDto.class, responseContainer = "List")
    @GetMapping("/v1/select-tree")
    public ServerResponse<List<Tree<String>>> getZdycxZts() {

        List<ZdycxZtTree> dtos = zdycxZtService.getZdycxZts();
        if (ObjectUtil.isEmpty(dtos)) return null;
        TreeNodeConfig config = new TreeNodeConfig();
        config.setParentIdKey("pDm");
        config.setNameKey("label");
        config.setIdKey("value");
        config.setWeightKey("value");
        config.setDeep(5);// 最大递归深度
        ZdycxZtTree ztDto = dtos.get(0);
        List<Tree<String>> treeList = TreeUtil.build(dtos, ztDto.getPDm(), config, (object, tree) -> {
            tree.setId(object.getValue());//必填属性
            tree.setParentId(object.getPDm());//必填属性
            tree.setName(object.getLabel());
            tree.setWeight(object.getValue());
            tree.putExtra("bmst", object.getBmst());
        });
        return ServerResponse.success(treeList);
    }
}