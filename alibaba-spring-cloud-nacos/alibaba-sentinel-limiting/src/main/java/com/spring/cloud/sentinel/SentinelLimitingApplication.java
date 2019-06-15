package com.spring.cloud.sentinel;


import com.alibaba.csp.sentinel.slots.block.RuleConstant;
import com.alibaba.csp.sentinel.slots.block.flow.FlowRule;
import com.alibaba.csp.sentinel.slots.block.flow.FlowRuleManager;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.List;


/**
 * 限流
 * @Auhtor:SimpleWu
 */
@SpringBootApplication
public class SentinelLimitingApplication {
    public static void main(String[] args) {

        //初始化限流规则
        initFlowRules();
        SpringApplication.run(SentinelLimitingApplication.class,args);
    }


    private static void initFlowRules() {
        List<FlowRule> rules = new ArrayList<>();
        FlowRule rule = new FlowRule();
        rule.setResource("annoSentine");
        rule.setGrade(RuleConstant.FLOW_GRADE_QPS);
        rule.setCount(1);
        rules.add(rule);
        FlowRuleManager.loadRules(rules);
    }
}
