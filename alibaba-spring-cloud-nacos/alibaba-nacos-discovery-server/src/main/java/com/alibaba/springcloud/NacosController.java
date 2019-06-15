package com.alibaba.springcloud;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class NacosController {

    @GetMapping("/hello")
    public String hello(){
        return "Nacos Controller";
    }
}
