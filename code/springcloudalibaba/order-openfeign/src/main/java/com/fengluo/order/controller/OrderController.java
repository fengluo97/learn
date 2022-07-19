package com.fengluo.order.controller;

import com.fengluo.order.feign.ProductFeignService;
import com.fengluo.order.feign.StockFeignService;
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
public class OrderController {

    @Autowired
    private StockFeignService stockFeignService;

    @Autowired
    private ProductFeignService productFeignService;

    @RequestMapping("/add")
    public String add() {
        System.out.println("下单成功!");
        String msg = stockFeignService.reduct();
        System.out.println(productFeignService.get(5));
        return "hello feign!" + msg + " " + productFeignService.get(5);
    }
}
