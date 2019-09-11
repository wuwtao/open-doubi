package com.simpel.springcloud.user;

import com.codingapi.txlcn.tc.config.EnableDistributedTransaction;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author: SimpleWu
 * @date: 2019/5/23
 */
@EnableEurekaClient
@SpringBootApplication(exclude = {SecurityAutoConfiguration.class })
@EnableDistributedTransaction
public class UserServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(UserServerApplication.class, args);
    }
}
