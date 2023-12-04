package cn.gov.chinatax.gt4.swrdsm.core.mp.interceptor;

import com.baomidou.mybatisplus.extension.plugins.pagination.DialectModel;
import com.baomidou.mybatisplus.extension.plugins.pagination.dialects.IDialect;

public class VerticaDialect implements IDialect {


    public VerticaDialect() {
    }

    public DialectModel buildPaginationSql(String originalSql, long offset, long limit) {
        String sql = originalSql + " limit " + "?";
        boolean existOffset = false;
        if (offset > 0L) {
            existOffset = true;
            sql = sql + " offset ?";
        }

        DialectModel model = new DialectModel(sql, limit, offset);
        return existOffset ? model.setConsumerChain() : model.setConsumer(true);
    }
}