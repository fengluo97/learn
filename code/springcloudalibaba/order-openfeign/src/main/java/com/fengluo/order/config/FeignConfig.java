package com.fengluo.order.config;

import feign.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author: fengluo
 * @Date: 2022/7/22 22:05
 */
//@Configuration // 作用于所有服务方，相当于全局配置；
public class FeignConfig {

    @Bean
    public Logger.Level feignLoggerLevel() {
        return Logger.Level.FULL;
    }

}
