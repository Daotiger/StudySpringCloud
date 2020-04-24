package com.daxiang.springcloud.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * @ClassName : OrderController
 * @Description : 控制层
 * @Author : Daotiger
 * @Date: 2020-04-24 10:11
 * @Version 1.0
 */
@RestController
@Slf4j
public class OrderController {

    public static final String INVOKE_URL = "http://cloud-provider-payment";

    @Resource
    private RestTemplate restTemplate;

    @GetMapping(value = "/consumer/payment/zk")
    public String getPayment() {

        String result = restTemplate.getForObject(INVOKE_URL + "/payment/zk", String.class);

        log.info("");

        return result;
    }

}
