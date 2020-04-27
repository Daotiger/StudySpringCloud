package com.daxiang.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @ClassName : OrderFeignMain80
 * @Description : 启动类
 * @Author : Daotiger
 * @Date: 2020-04-25 11:14
 * @Version 1.0
 */
@SpringBootApplication
@EnableFeignClients //开启Feign
public class OrderFeignMain80 {

    public static void main(String[] args) {
        SpringApplication.run(OrderFeignMain80.class, args);
    }
}
