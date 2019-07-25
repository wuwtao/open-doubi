package com.boot.quartz;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * @author:伍梓涛
 * @version:1.0.0
 * @Modified By:SimpleWu
 * @CopyRright (c)2019-:YUM架构平台
 *
 * <p>
 *     api 运行地址 http://localhost:8081/swagger-ui.html
 *     job_info插入规则:{
 *         1.所有job_group_name应该为统一一个方便管理
 *         2.job_type 为1时 job_time应该是cron表达式 不支持设置运行次数
 *         3.job_type 为2时 job_time应该是秒 并且可是设置运行次数job_count
 *     }
 *     本工程为主工程
 * </p>
 */
@SpringBootApplication
//多模块加载扫描
//@ComponentScan(basePackages = "")
public class CommonQuartzApplication {
    public static void main(String[] args) {
        ConfigurableApplicationContext run = SpringApplication.run(CommonQuartzApplication.class, args);
    }
}
