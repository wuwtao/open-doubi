package com.simpel.springcloud.user.mapper;


import org.apache.ibatis.annotations.Mapper;

import java.util.Map;

/**
 * @author: SimpleWu
 * @date: 2019/5/24
 */
@Mapper
public interface UserServerMapper {

    public int insert(Map<String,Object> map);
}
