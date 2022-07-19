package com.fengluo.product.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: fengluo
 * @Date: 2022/6/3 18:24
 */
@RestController
@RequestMapping("/product")
public class ProductController {

    @Value("${server.port}")
    private String port;

    @RequestMapping("/{id}")
    public String get(@PathVariable("id") Integer id) {

        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("查询商品：" + id);
        return "查询商品：" + id + ": " + port;
    }
}
