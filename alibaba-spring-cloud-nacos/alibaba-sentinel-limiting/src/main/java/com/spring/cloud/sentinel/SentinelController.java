package com.spring.cloud.sentinel;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SentinelController {

    /**
     * 在Sentine控制台设置 流控，降级等等。
     * QPS 设置为2 每秒最多2个请求 ，可以快速调用进行测试
     * @return
     */
    @GetMapping("sentinel")
    public String sentinel(){
        return "sentinel";
    }


    /**
     * 注解限流,可配合fegin使用
     * @return
     */
    @SentinelResource(value = "annoSentine", blockHandler = "handleException", blockHandlerClass = { SentinelUtil.class })
    @GetMapping("annotation")
    public String annotation(){
        return "annotation";
    }
}
