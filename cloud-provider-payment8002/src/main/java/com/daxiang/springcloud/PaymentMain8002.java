package com.daxiang.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @ClassName : Payment8002
 * @Description : 支付提供类
 * @Author : Daotiger
 * @Date: 2020-04-22 17:22
 * @Version 1.0
 */
@SpringBootApplication
@EnableEurekaClient
public class PaymentMain8002 {

    public static void main(String[] args) {
        SpringApplication.run(PaymentMain8002.class, args);
    }
}
