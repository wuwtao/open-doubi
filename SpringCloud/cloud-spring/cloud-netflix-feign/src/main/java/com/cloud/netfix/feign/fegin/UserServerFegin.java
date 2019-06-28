package com.cloud.netfix.feign.fegin;

import com.cloud.netfix.feign.fegin.hystrix.UserServerFeginHystrix;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Component
@FeignClient(name = "cloud-netflix-eureka-client" ,fallback = UserServerFeginHystrix.class)
public interface UserServerFegin {
    @GetMapping("getName/{name}")
    public String getName(@PathVariable("name") String name);
}
