package com.spring.boot.mybatis.mapper;

import com.spring.boot.mybatis.pojo.Pager;

import java.util.List;
import java.util.Map;

/**
 * @author:伍梓涛
 * @version:1.0.0
 * @Modified By:SimpleWu
 * @CopyRright (c)2019-:YUM架构平台
 */
public interface UserMapper {

    int updateById(String id);

    List<Map<String, Object>> selectAll();

    List<Map<String, Object>> selectById(Pager pager, Pager pager2);

}
