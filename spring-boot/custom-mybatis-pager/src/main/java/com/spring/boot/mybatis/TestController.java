package com.spring.boot.mybatis;

import com.spring.boot.mybatis.mapper.UserMapper;
import com.spring.boot.mybatis.pojo.Pager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author:伍梓涛
 * @version:1.0.0
 * @Modified By:SimpleWu
 * @CopyRright (c)2019-:YUM架构平台
 */
@RestController
public class TestController {

    @Autowired
    private UserMapper userMapper;

    @GetMapping("test")
    public Object getUser() {
        Pager pager = new Pager();
        pager.setPage(10);
        pager.setSize(2);
        System.out.println(userMapper.selectById(pager, pager));
        return pager;
    }
}
