package com.fengluo.order.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @Author: fengluo
 * @Date: 2022/6/3 18:21
 */
@RestController
@RequestMapping("/order")
public class Order {

    @Autowired
    private RestTemplate restTemplate;

    @RequestMapping("/add")
    public String add() {
        System.out.println("下单成功!");
        String msg = restTemplate.getForObject("http://stock-service/stock/reduct", String.class);

        return "hello world!" + msg;
    }
}
