package com.simple.springcloud.money;

import com.codingapi.txlcn.tc.config.EnableDistributedTransaction;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author: SimpleWu
 * @date: 2019/5/24
 */
@EnableFeignClients
@EnableEurekaClient
@EnableDistributedTransaction
@SpringBootApplication
@EnableDiscoveryClient
public class MoneyAppliction {
    public static void main(String[] args) {
        SpringApplication.run(MoneyAppliction.class, args);
    }
}
