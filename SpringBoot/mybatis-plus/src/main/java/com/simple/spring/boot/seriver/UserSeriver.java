package com.simple.spring.boot.seriver;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.simple.spring.boot.entities.User;
import com.simple.spring.boot.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

/**
 * @title: ${name}
 * @author: SimpleWu
 * @date: 2019/5/25
 */
@Service
public class UserSeriver {

    @Autowired
    private UserMapper userMapper;

    public List<User> getList(){
        return userMapper.selectList(null);
    }

    public List<User> getListQuery(){
        User user = new User();
        user.setName("SimpleWu");
        Wrapper<User> wrapper = new QueryWrapper<>(user);
        return userMapper.selectList(wrapper);
    }

    public IPage<User> page(){
        int currentPage = 1 ; //当前页
        int pageSize = 2 ;//每页大小
        IPage<User> page = new Page(currentPage,pageSize);
        page = userMapper.selectPage(page,null);
        return page;
    }

    @Transactional//本地事务开启
    public int insert(){
        User user = new User();
        user.setId(6l);
        user.setName("SimpleWu");
        user.setAge(100);
        user.setEmail("SimpleWu@gmail.com");
        return userMapper.insert(user);
    }

    @Transactional//本地事务开启
    public int deleteById(){
        int userId = 6;
        return userMapper.deleteById(userId);
    }

    @Transactional//本地事务开启
    public int updateById(){
        User user = new User();
        user.setId(5l);
        user.setName("update");
        user.setAge(100);
        user.setEmail("update@email.com");
       return userMapper.updateById(user);
    }

    @Transactional//本地事务开启
    public int updateWrapperUser(){
        User user = new User();
        user.setId(5l);
        user.setName("update");
        user.setAge(100);
        user.setEmail("update@email.com");

        User updateWrapperUser = new User();
        updateWrapperUser.setId(1l);

        /**
         * 修改 UpdateWrapper
         * 查询 QueryWrapper
         */
        Wrapper<User> wrapper = new UpdateWrapper<>(updateWrapperUser);
        return userMapper.update(user,wrapper);
    }

    public Map<String,Object> myMapper(){
        return userMapper.queryUser("2");
    }


}
