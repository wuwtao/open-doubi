package com.cloud.netfix.feign.fegin.hystrix;

import com.cloud.netfix.feign.fegin.UserServerFegin;
import org.springframework.stereotype.Component;

@Component
public class  UserServerFeginHystrix implements UserServerFegin {

    @Override
    public String getName(String name) {
        return name + "Producer Server 的服务调用失败";
    }
}
