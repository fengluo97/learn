package com.fengluo.ribbon;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author: fengluo
 * @Date: 2022/6/4 21:17
 */
@Configuration
public class RibbonRandomRuleConfig {

    @Bean
    public IRule iRule() {
        return new RandomRule();
    }
}
