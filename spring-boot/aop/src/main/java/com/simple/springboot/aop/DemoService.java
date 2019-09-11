package com.simple.springboot.aop;

import org.springframework.stereotype.Service;

/**
 * @author: SimpleWu
 * @date: 2019/5/27
 */
@Service
public class DemoService {

    public String hello(String str){
        return str;
    }
}
