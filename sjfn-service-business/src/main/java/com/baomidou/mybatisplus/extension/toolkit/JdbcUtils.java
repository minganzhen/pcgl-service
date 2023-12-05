package com.baomidou.mybatisplus.extension.toolkit;

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.core.toolkit.Assert;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import org.apache.ibatis.logging.Log;
import org.apache.ibatis.logging.LogFactory;
public class JdbcUtils {
    private static final Log logger = LogFactory.getLog(JdbcUtils.class);

    public JdbcUtils() {
    }

    public static DbType getDbType(String jdbcUrl) {
        Assert.isFalse(StringUtils.isBlank(jdbcUrl), "Error: The jdbcUrl is Null, Cannot read database type", new Object[0]);
        String url = jdbcUrl.toLowerCase();
        if (!url.contains(":mysql:") && !url.contains(":cobar:")) {
            if (url.contains(":mariadb:")) {
                return DbType.MARIADB;
            } else if (url.contains(":oracle:")) {
                return DbType.ORACLE;
            } else if (!url.contains(":sqlserver:") && !url.contains(":microsoft:")) {
                if (url.contains(":sqlserver2012:")) {
                    return DbType.SQL_SERVER;
                } else if (url.contains(":postgresql:")) {
                    return DbType.POSTGRE_SQL;
                } else if (url.contains(":hsqldb:")) {
                    return DbType.HSQL;
                } else if (url.contains(":vertica:")) {
                    return DbType.VERTICA;
                } else if (url.contains(":db2:")) {
                    return DbType.DB2;
                } else if (url.contains(":sqlite:")) {
                    return DbType.SQLITE;
                } else if (url.contains(":h2:")) {
                    return DbType.H2;
                } else if (url.contains(":dm:")) {
                    return DbType.DM;
                } else if (url.contains(":xugu:")) {
                    return DbType.XU_GU;
                } else if (!url.contains(":kingbase:") && !url.contains(":kingbase8:")) {
                    if (url.contains(":phoenix:")) {
                        return DbType.PHOENIX;
                    } else if (jdbcUrl.contains(":zenith:")) {
                        return DbType.GAUSS;
                    } else {
                        logger.warn("The jdbcUrl is " + jdbcUrl + ", Mybatis Plus Cannot Read Database type or The Database's Not Supported!");
                        return DbType.OTHER;
                    }
                } else {
                    return DbType.KINGBASE_ES;
                }
            } else {
                return DbType.SQL_SERVER2005;
            }
        } else {
            return DbType.MYSQL;
        }
    }
}