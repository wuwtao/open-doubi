package com.simple.springcloud.money.fegin;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @title: ${name}
 * @author: SimpleWu
 * @date: 2019/5/24
 */
@Component
@FeignClient("user-server")
public interface UserFegin {

    @GetMapping("hello")
    public String hello(@RequestParam("name") String name, @RequestParam("pass")  String pass, @RequestParam("id") String id);
}
