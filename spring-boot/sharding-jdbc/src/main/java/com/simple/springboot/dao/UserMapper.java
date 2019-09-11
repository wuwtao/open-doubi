package com.simple.springboot.dao;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.Map;

/**
 * @author: SimpleWu
 * @date: 2019/6/3
 */
@Mapper
public interface UserMapper {

    @Insert("INSERT INTO TB_USER(USER_NAME,USER_PHONE) VALUES(UUID(),UUID())")
    int insert();

    @Select("SELECT * FROM TB_USER")
    Map<String,Object> select();
}
