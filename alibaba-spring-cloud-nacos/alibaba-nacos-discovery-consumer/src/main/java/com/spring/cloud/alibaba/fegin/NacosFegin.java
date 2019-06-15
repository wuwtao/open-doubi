package com.spring.cloud.alibaba.fegin;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * 获取服务名称cloud-client
 */
@FeignClient("cloud-client")
public interface NacosFegin {

    @GetMapping("/hello")
    String hello();
}
