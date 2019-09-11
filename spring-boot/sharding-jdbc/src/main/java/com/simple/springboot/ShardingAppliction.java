package com.simple.springboot;


import com.simple.springboot.dao.UserMapper;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * @author: SimpleWu
 * @date: 2019/6/3
 */
@SpringBootApplication(scanBasePackages = "com.simple.springboot")
@RestController
@MapperScan("com.simple.springboot.dao")
public class ShardingAppliction {
    public static void main(String[] args) {
        SpringApplication.run(ShardingAppliction.class, args);
    }

    @Autowired
    private UserMapper userMapper;

    @GetMapping("insert")
    public String insert(){
        if(userMapper.insert() == 1){
            return "success user";
        }
        return "error user";
    }

    @GetMapping("select")
    public Map<String,Object> select(){
        return userMapper.select();
    }

}
