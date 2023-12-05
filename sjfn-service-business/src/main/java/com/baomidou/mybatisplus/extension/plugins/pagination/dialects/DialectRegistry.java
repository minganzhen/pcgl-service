package com.baomidou.mybatisplus.extension.plugins.pagination.dialects;

import cn.gov.chinatax.gt4.swrdsm.core.mp.interceptor.VerticaDialect;
import com.baomidou.mybatisplus.annotation.DbType;

import java.util.Collection;
import java.util.Collections;
import java.util.EnumMap;
import java.util.Map;

public class DialectRegistry {
    private final Map<DbType, IDialect> dialect_enum_map = new EnumMap(DbType.class);

    public DialectRegistry() {
        this.dialect_enum_map.put(DbType.MYSQL, new MySqlDialect());
        this.dialect_enum_map.put(DbType.MARIADB, new MariaDBDialect());
        this.dialect_enum_map.put(DbType.ORACLE, new OracleDialect());
        this.dialect_enum_map.put(DbType.ORACLE_12C, new Oracle12cDialect());
        this.dialect_enum_map.put(DbType.DB2, new DB2Dialect());
        this.dialect_enum_map.put(DbType.H2, new H2Dialect());
        this.dialect_enum_map.put(DbType.HSQL, new HSQLDialect());
        this.dialect_enum_map.put(DbType.SQLITE, new SQLiteDialect());
        this.dialect_enum_map.put(DbType.POSTGRE_SQL, new PostgreDialect());
        this.dialect_enum_map.put(DbType.SQL_SERVER2005, new SQLServer2005Dialect());
        this.dialect_enum_map.put(DbType.SQL_SERVER, new SQLServerDialect());
        this.dialect_enum_map.put(DbType.DM, new DmDialect());
        this.dialect_enum_map.put(DbType.XU_GU, new XuGuDialect());
        this.dialect_enum_map.put(DbType.KINGBASE_ES, new KingbaseDialect());
        this.dialect_enum_map.put(DbType.PHOENIX, new PhoenixDialect());
        this.dialect_enum_map.put(DbType.VERTICA, new VerticaDialect());
        this.dialect_enum_map.put(DbType.GAUSS, new GaussDialect());
    }

    public IDialect getDialect(DbType dbType) {
        return (IDialect)this.dialect_enum_map.get(dbType);
    }

    public Collection<IDialect> getDialects() {
        return Collections.unmodifiableCollection(this.dialect_enum_map.values());
    }
}