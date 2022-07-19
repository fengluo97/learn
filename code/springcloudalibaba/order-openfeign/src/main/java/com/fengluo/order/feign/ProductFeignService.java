package com.fengluo.order.feign;

import com.fengluo.order.config.FeignConfig;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Author: fengluo
 * @Date: 2022/7/22 22:10
 */
@FeignClient(name = "product-service", path = "/product", configuration = FeignConfig.class)
public interface ProductFeignService {

    @RequestMapping("/{id}")
    String get(@PathVariable("id") Integer id);

}
