package com.simple.springcloud.money.mapper;

import org.apache.ibatis.annotations.Mapper;

import java.util.Map;

/**
 * @title: ${name}
 * @author: SimpleWu
 * @date: 2019/5/24
 */
@Mapper
public interface MoneyServerMapper {

    public int insert(Map<String,Object> map);
}
