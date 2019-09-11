package com.cloud.netfix.eureka.com.cloud.netfilx.eureka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * Eureka注册中心服务
 * @author SimpleWu
 */
@SpringBootApplication
@EnableEurekaServer
public class CommenEurekaServerApplication {
    public static void main(String[] args) {
        SpringApplication.run(CommenEurekaServerApplication.class,args);
    }
}
