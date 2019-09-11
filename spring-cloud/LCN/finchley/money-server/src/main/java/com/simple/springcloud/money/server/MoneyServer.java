package com.simple.springcloud.money.server;

import com.simple.springcloud.money.ibiz.IMoneyServerBiz;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * @title: ${name}
 * @author: SimpleWu
 * @date: 2019/5/24
 */
@RestController
public class MoneyServer {

    @Autowired
    private IMoneyServerBiz iMoneyServerBiz;

    @GetMapping("hello")
    public String hello(){
        return iMoneyServerBiz.insert();
    }

}
