package com.cloud.netflix.eureka.service;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserService {

    @Value("server.port")
    private String port;

    @GetMapping("getName/{name}")
    public String getName(@PathVariable("name") String name){
        return name + " -----> " + port;
    }

}
