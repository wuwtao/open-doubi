package com.simpel.springcloud.user.server;

import com.simpel.springcloud.user.ibiz.IUserServerBiz;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@RestController
public class UserServer {

    @Autowired
    private IUserServerBiz userServerBiz;

    @GetMapping("hello")
    public String hello(@RequestParam("name") String name,@RequestParam("pass")  String pass, @RequestParam("id") String id){

        Map<String,Object> map = new HashMap<>();
        map.put("USER_NAME",name);
        map.put("USER_PASS",pass);
        map.put("USER_ID",id);
        map.put("ID",id);



        int flag = userServerBiz.insertUser(map);

        if(flag == 1){
            return "add success";
        }else
            return "add error";


    }
}