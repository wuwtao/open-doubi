package com.simple.springboot.config;

import com.alibaba.druid.pool.DruidDataSource;
import io.shardingsphere.core.api.config.MasterSlaveRuleConfiguration;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.HashMap;
import java.util.Map;

/**
 * @title: ${name}
 * @author: SimpleWu
 * @date: 2019/6/3
 */
@Data
@ConfigurationProperties(prefix = "sharding.jdbc")
public class ShardingMasterSlaveConfig {

    private Map<String, DruidDataSource> dataSources = new HashMap<>();

    private MasterSlaveRuleConfiguration masterSlaveRule;
}
