package com.spring.boot.mybatis.interceptor;

import com.spring.boot.mybatis.handler.PagerHandler;
import com.spring.boot.mybatis.pojo.Pager;
import org.apache.ibatis.executor.parameter.ParameterHandler;
import org.apache.ibatis.executor.statement.StatementHandler;
import org.apache.ibatis.mapping.BoundSql;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.mapping.SqlCommandType;
import org.apache.ibatis.plugin.*;
import org.apache.ibatis.reflection.DefaultReflectorFactory;
import org.apache.ibatis.reflection.MetaObject;
import org.apache.ibatis.reflection.SystemMetaObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.Map;
import java.util.Properties;

/**
 * @author:伍梓涛
 * @version:1.0.0
 * @Modified By:SimpleWu
 * @CopyRright (c)2019-:YUM架构平台
 */
@ConditionalOnBean
@Component
@Intercepts(value = {
        @Signature(type = StatementHandler.class, method = "prepare", args = {Connection.class, Integer.class})})
public class PagerMyBatisInterceptor implements PagerHandler, Interceptor {

    private final Logger log = LoggerFactory.getLogger(PagerMyBatisInterceptor.class);

    private final int CONNECTION_INDEX = 0;

    private final DefaultReflectorFactory DEFAULT_REFLECTOR_FACTORY = new DefaultReflectorFactory();

    private final String DELEGATE_MAPPED_STATEMENT = "delegate.mappedStatement";

    private final String DELEGATE_PARAMETER_HANDLER = "delegate.parameterHandler";

    @Override
    public Object intercept(Invocation invocation) throws Throwable {
        Object[] args = invocation.getArgs();
        Connection connection = (Connection) args[CONNECTION_INDEX];
        StatementHandler statementHandler = (StatementHandler) invocation.getTarget();
        MetaObject metaObject = MetaObject.forObject(statementHandler, SystemMetaObject.DEFAULT_OBJECT_FACTORY,
                SystemMetaObject.DEFAULT_OBJECT_WRAPPER_FACTORY, DEFAULT_REFLECTOR_FACTORY);
        MappedStatement mappedStatement = (MappedStatement) metaObject.getValue(DELEGATE_MAPPED_STATEMENT);
        SqlCommandType sqlCommandType = mappedStatement.getSqlCommandType();
        BoundSql boundSql = statementHandler.getBoundSql();
        Pager pager = getPager(boundSql);
        if (sqlCommandType.compareTo(SqlCommandType.SELECT) == 0 && pager != null) {
            executer(pager, boundSql, connection, metaObject);
            //执行查询
            int left = (pager.getPage() - 1) * pager.getSize();
            int right = pager.getSize();
            String rewriteSql = boundSql.getSql() + " LIMIT " + left + "," + right;
            metaObject.setValue("boundSql.sql", rewriteSql);
        }
        long startTime = System.currentTimeMillis();
        Object proceed = invocation.proceed();
        long endTime = System.currentTimeMillis();
        log.info("SQL TYPE [{}] , SQL EXECUTE TIME [{}] SQL:\n{}", sqlCommandType, startTime - endTime, boundSql.getSql().toUpperCase());
        return proceed;
    }

    @Override
    public Object plugin(Object target) {
        return Plugin.wrap(target, this);
    }

    @Override
    public void setProperties(Properties properties) {
        //TODO 设置mybatis参数
    }

    @Override
    public Pager getPager(BoundSql boundSql) {
        Object parameterObject = boundSql.getParameterObject();
        if (parameterObject instanceof Pager) {
            return (Pager) parameterObject;
        } else if (parameterObject instanceof Map) {
            Map<String, Object> paramMap = (Map<String, Object>) parameterObject;
            Iterator<String> keys = paramMap.keySet().iterator();
            while (keys.hasNext()) {
                String key = keys.next();
                Object obj = paramMap.get(key);
                if (obj instanceof Pager) {
                    return (Pager) obj;
                }
            }

        }
        return null;
    }

    @Override
    public Pager executer(Pager pager, BoundSql boundSql, Connection connection, MetaObject metaObject) throws SQLException {
        if (pager.getPage() == 0) {
            pager.setPage(0);
        }
        if (pager.getSize() == 0) {
            pager.setSize(0);
        }
        if (pager.getCustomSQL() == null) {
            pager.setCustomSQL("SELECT COUNT(1) FROM (" + boundSql.getSql() + " ) tmp_table");
        }
        // 预编译
        PreparedStatement prepareStatement = connection.prepareStatement(pager.getCustomSQL());
        // 预编译执行
        ParameterHandler parameterHandler = (ParameterHandler) metaObject.getValue(DELEGATE_PARAMETER_HANDLER);
        parameterHandler.setParameters(prepareStatement); // 给sql语句设置参数
        long startTime = System.currentTimeMillis();
        ResultSet resultSet = prepareStatement.executeQuery();
        long endTime = System.currentTimeMillis();
        log.info("sql execute time {} sql:\n{}", startTime - endTime, pager.getCustomSQL().toUpperCase());
        if (resultSet.next()) {
            long total = (long) resultSet.getObject(1);// 总记录数量
            int totalPageNum = (int) ((total + pager.getSize() - 1) / pager.getSize());
            pager.setTotal(total);
            pager.setTotalPage(totalPageNum);
            pager.setExecuteTime(startTime - endTime);
        }
        return pager;
    }
}
