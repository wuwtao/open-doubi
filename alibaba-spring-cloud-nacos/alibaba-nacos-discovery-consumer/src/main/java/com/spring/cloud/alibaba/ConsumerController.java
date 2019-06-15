package com.spring.cloud.alibaba;

import com.spring.cloud.alibaba.fegin.NacosFegin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ConsumerController {

    @Autowired
    private NacosFegin nacosFegin;

    @GetMapping("/consumer")
    public String consumer(){
        return nacosFegin.hello();
    }
}
