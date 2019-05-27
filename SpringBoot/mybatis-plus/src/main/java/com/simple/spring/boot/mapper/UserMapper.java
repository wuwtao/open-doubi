package com.simple.spring.boot.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.simple.spring.boot.entities.User;
import org.apache.ibatis.annotations.Param;

import java.util.Map;

/**
 * @title: ${name}
 * @author: SimpleWu
 * @date: 2019/5/25
 */
public interface UserMapper extends BaseMapper<User> {

    Map<String,Object> queryUser(@Param("USER_ID") String userId);
}
