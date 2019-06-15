package com.spring.cloud.alibaba;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;


/**
 * SpringCloud Alibaba 通过Fegin进行远程调用进行消费
 * @EnableDiscoveryClient 开启服务发现
 * @EnableFeignClients 开启feign
 * @Author SimpleWu
 */
@EnableDiscoveryClient
@EnableFeignClients
@SpringBootApplication
public class ConsumerAppliction {
    public static void main(String[] args) {
        SpringApplication.run(ConsumerAppliction.class , args);
    }
}
