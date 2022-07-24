package com.fengluo.sentinel.controller;

import com.alibaba.csp.sentinel.Entry;
import com.alibaba.csp.sentinel.SphU;
import com.alibaba.csp.sentinel.Tracer;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.alibaba.csp.sentinel.slots.block.Rule;
import com.alibaba.csp.sentinel.slots.block.RuleConstant;
import com.alibaba.csp.sentinel.slots.block.flow.FlowRule;
import com.alibaba.csp.sentinel.slots.block.flow.FlowRuleManager;
import com.fengluo.sentinel.pojo.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author: fengluo
 * @Date: 2022/7/23 23:02
 */
@RestController
@Slf4j
public class HelloController {

    private static final String RESOURCE_NAME = "hello";
    private static final String USER_RESOURCE_NAME = "user";
    private static final String DEGRADE_RESOURCE_NAME = "degrade";

    @PostConstruct
    private static void initFlowRules() {
        List<FlowRule> rules = new ArrayList<>();
        FlowRule rule = new FlowRule();
        // 设置要保护的资源
        rule.setResource(USER_RESOURCE_NAME);
        // 设置流控规则 QPS
        rule.setGrade(RuleConstant.FLOW_GRADE_QPS);
        //设置受保护的资源阈值
        rule.setCount(1);
        rules.add(rule);
        // 加载配置好的规则
        FlowRuleManager.loadRules(rules);
    }

    @RequestMapping("/user")
    @SentinelResource(value = USER_RESOURCE_NAME, blockHandler = "blockHandlerForGetUser")
    public User getUser(String id) {
        return new User("fengluo");
    }

    public User blockHandlerForGetUser(String id, BlockException e) {
        e.printStackTrace();
        return new User("流控！");
    }
}
