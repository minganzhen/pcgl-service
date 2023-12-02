package cn.gov.chinatax.gt4.swrdsm.api.zdycx;

import cn.hutool.core.lang.tree.Tree;
import com.tencent.gov.goff.common.v2.pojo.bean.ServerResponse;
import io.swagger.annotations.Api;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

/**
 * 自定义查询主题
 *
 * @author huax
 * @date 2023-11-21
 */
@Api(tags = "自定义查询 - 主题接口")
@FeignClient(value = "sjfn-service", contextId = "ZdycxZtApi", path = "/sjfn/api/zdycx-zt")
public interface ZdycxZtApi {


    /**
     * 获取主题树
     *
     * @return
     */
    @GetMapping("/v1/select-tree")
    public ServerResponse<List<Tree<String>>> getZdycxZts();
}