package com.spring.boot.mybatis.handler;

import com.spring.boot.mybatis.pojo.Pager;
import org.apache.ibatis.mapping.BoundSql;
import org.apache.ibatis.reflection.MetaObject;

import java.sql.Connection;
import java.sql.SQLException;

public interface PagerHandler {
    /**
     * 获取sql执行参数
     * @param boundSql
     * @return
     */
    public Pager getPager(BoundSql boundSql);

    /**
     * 执行分页
     *
     * @param pager
     * @param boundSql
     * @param connection
     * @param metaObject
     * @return
     * @throws SQLException
     */
    public Pager executer(Pager pager, BoundSql boundSql, Connection connection, MetaObject metaObject) throws SQLException;

}
