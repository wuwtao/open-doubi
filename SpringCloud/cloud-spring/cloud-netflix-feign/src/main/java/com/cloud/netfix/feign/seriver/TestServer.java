package com.cloud.netfix.feign.seriver;

import com.cloud.netfix.feign.fegin.UserServerFegin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestServer {

    @Autowired
    private UserServerFegin userServerFegin;

    @Value("server.port")
    private String port;

    @GetMapping("/getUserName/{name}")
    public String getUserName(@PathVariable("name") String name){
        return port + "------>" +userServerFegin.getName(name);
    }
}
