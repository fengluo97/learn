package com.fengluo.order.interceptor;

import feign.RequestInterceptor;
import feign.RequestTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @Author: fengluo
 * @Date: 2022/7/22 22:52
 */
public class CustomFeignInterceptor implements RequestInterceptor {

    private static final Logger logger = LoggerFactory.getLogger(CustomFeignInterceptor.class);

    @Override
    public void apply(RequestTemplate requestTemplate) {

    }
}
