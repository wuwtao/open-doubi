package com.simple.springcloud.eureka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;
import org.springframework.context.ApplicationContext;

/**
 * @author: SimpleWu
 * @date: 2019/5/23
 */
@EnableEurekaServer
@SpringBootApplication
public class CommonEurekaApp {
    public static void main(String[] args) {
       ApplicationContext run = SpringApplication.run(CommonEurekaApp.class, args);
    }
}
