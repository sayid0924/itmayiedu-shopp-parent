package com.jzr.common;

import com.mysql.cj.MysqlConnection;
import com.mysql.cj.Query;
import com.mysql.cj.interceptors.QueryInterceptor;
import com.mysql.cj.log.Log;
import com.mysql.cj.protocol.Resultset;
import com.mysql.cj.protocol.ServerSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Properties;
import java.util.function.Supplier;

public class LogSqlQueryInterceptor implements QueryInterceptor {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Override
    public QueryInterceptor init(MysqlConnection conn, Properties props, Log log) {
        return this;
    }

    @Override
    public <T extends Resultset> T preProcess(Supplier<String> sql, Query interceptedQuery) {
        if (interceptedQuery != null) {
//            if (LogUtil.SQL_LOG.isDebugEnabled()) {
//                LogUtil.SQL_LOG.debug("sql: {}", SQLUtils.formatMySql(sql.toString()));
//            }
        }
        return null;
    }

    @Override
    public boolean executeTopLevelOnly() {
        return false;
    }

    @Override
    public void destroy() {

    }

    @Override
    public <T extends Resultset> T postProcess(Supplier<String> sql, Query interceptedQuery, T originalResultSet, ServerSession serverSession) {
        return null;
    }
}
