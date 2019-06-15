package com.spring.cloud.dev;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.spring.cloud.alibaba,com.alibaba.springcloud")
public class App {
    public static void main(String[] args) {
        SpringApplication.run(App.class,args);
    }
}
