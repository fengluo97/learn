package com.fengluo.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * @Author: fengluo
 * @Date: 2022/7/22 23:34
 */
@SpringBootApplication
public class ConfigApplication {

    public static void main(String[] args) throws InterruptedException {

        ConfigurableApplicationContext applicationContext = SpringApplication.run(ConfigApplication.class, args);
        while (true) {
            String userName = applicationContext.getEnvironment().getProperty("user.name");
            String userAge = applicationContext.getEnvironment().getProperty("user.age");
            System.out.println("user name: " + userName + ";  user age: " + userAge);
            Thread.sleep(1000);
        }
    }

}
