package com.simple.spring.boot.controller;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.simple.spring.boot.entities.User;
import com.simple.spring.boot.seriver.UserSeriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/**
 * @author: SimpleWu
 * @date: 2019/5/25
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserSeriver userSeriver;

    /**
     * 查询实体类
     * @return
     */
    @GetMapping("/list")
    public List<User> getList(){
        return  userSeriver.getList();
    }

    /**
     * 分页查询
     * @return
     */
    @GetMapping("/page")
    public IPage<User> page(){
        return  userSeriver.page();
    }

    /**
     * 插入
     * @return
     */
    @GetMapping("/insert")
    public String insert(){
        return  userSeriver.insert() == 1 ? "insert success!!" : "rallback";
    }

    /**
     * 按照主键删除
     * @return
     */
    @GetMapping("/deleteById")
    public String deleteById(){
        return  userSeriver.deleteById() == 1 ? "deleteById success!!" : "rallback";
    }

    /**
     * 按照主键修改
     * @return
     */
    @GetMapping("/updateById")
    public String updateById(){
        return  userSeriver.deleteById() == 1 ? "updateById success!!" : "rallback";
    }
    /**
     * 按照主键修改
     * @return
     */
    @GetMapping("/updateWrapperUser")
    public String updateWrapperUser(){
        return  userSeriver.updateWrapperUser() == 1 ? "updateById success!!" : "rallback";
    }


    /**
     * 指定Mapper
     */
    @GetMapping("/myMapper")
    public Map<String,Object> myMapper(){
        return  userSeriver.myMapper();
    }

    /**
     * 查询集合带条件
     * @return
     */
    @GetMapping("/getListQuery")
    public List<User> getListQuery(){
        return userSeriver.getListQuery();
    }


}
