package cn.gov.chinatax.gt4.swrdsm.config;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.Date;

/**
 * 自动填充处理
 *
 * @author huax
 */
@Component
public class MyMetaObjectHandler implements MetaObjectHandler {

    /**
     * 插入时的填充策略
     */
    @Override
    public void insertFill(MetaObject metaObject) {
        // 创建和修改时间自动填充当前时间
        this.strictInsertFill(metaObject, "lrrq", Date.class, new Date());
        this.strictInsertFill(metaObject, "xgrq", Date.class, new Date());
        this.strictInsertFill(metaObject, "ywqdDm", String.class, "swzj.zjnb.swrd");
        this.strictInsertFill(metaObject, "sjtbSj", Date.class, new Date());
    }

    /**
     * 更新时的填充策略
     */
    @Override
    public void updateFill(MetaObject metaObject) {
        // 修改时间自动填充当前时间
        this.strictUpdateFill(metaObject, "xgrq", Date.class, new Date());
    }

}
