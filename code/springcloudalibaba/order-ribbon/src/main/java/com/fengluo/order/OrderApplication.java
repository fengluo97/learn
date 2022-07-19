package com.fengluo.order;

import com.fengluo.ribbon.RibbonRandomRuleConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.netflix.ribbon.RibbonClients;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

/**
 * @Author: fengluo
 * @Date: 2022/6/3 18:27
 */
@SpringBootApplication
@RibbonClients(value = {
        @RibbonClient(name = "stock-service", configuration = RibbonRandomRuleConfig.class)
})
public class OrderApplication {

    @Bean
    @LoadBalanced
    public RestTemplate restTemplate(RestTemplateBuilder builder) {
        RestTemplate restTemplate = builder.build();
        return restTemplate;
    }

    public static void main(String[] args) {
        SpringApplication.run(OrderApplication.class);
    }
}
