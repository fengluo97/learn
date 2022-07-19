package com.fengluo.order.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Author: fengluo
 * @Date: 2022/7/22 21:11
 */
// name 指定所调用接口的服务名，path 指定所调用接口的 @RequestMapping
@FeignClient(name = "stock-service", path = "/stock")
public interface StockFeignService {

    // 声明需要调用的 rest 接口对应的方法
    @RequestMapping("/reduct")
    String reduct();

}
