package com.daxiang.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @ClassName : PaymentHystrixMain8001
 * @Description : 启动类
 * @Author : Daotiger
 * @Date: 2020-04-27 14:24
 * @Version 1.0
 */
@SpringBootApplication  //使能springboot
@EnableEurekaClient     //使能eureka
@EnableCircuitBreaker   //开启断路器功能
public class PaymentHystrixMain8001 {

    public static void main(String[] args) {
        SpringApplication.run(PaymentHystrixMain8001.class, args);
    }
}
