package com.fengluo.product.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: fengluo
 * @Date: 2022/6/3 18:24
 */
@RestController
@RequestMapping("/stock")
public class Stock {

    @Value("${server.port}")
    private String port;

    @RequestMapping("/reduct")
    public String reduct() {
        System.out.println("扣减库存" + port);
        return "扣减库存" + port;
    }
}
