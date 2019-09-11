package com.simple.springboot.logback.logger;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: SimpleWu
 * @date: 2019/5/27
 */
@RestController
public class DemoService {
    private Logger logger = LoggerFactory.getLogger(DemoService.class);

    @GetMapping("/hello")
    public String hello(){
        logger.error("hello ---> {}","abc");
        return "1";
    }
}
