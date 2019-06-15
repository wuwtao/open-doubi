package com.alibaba.spring.cloud;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * 后续我们会通过这个接口来验证Nacos中配置的加载。
 * 另外，这里还有一个比较重要的注解@RefreshScope，
 * 主要用来让这个类下的配置内容支持动态刷新，
 * 也就是当我们的应用启动之后，
 * 修改了Nacos中的配置内容之后，这里也会马上生效。
 * @Author SimpleWu
 */
@RestController
@RefreshScope
public class ConfigController {
    @Value("${didispace.title:}")
    private String title;

    @GetMapping("/test")
    public String hello() {
        return title;
    }
}
