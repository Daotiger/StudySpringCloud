package com.daxiang.springcloud.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

/**
 * @ClassName : PaymentController
 * @Description : 控制层
 * @Author : Daotiger
 * @Date: 2020-04-24 11:12
 * @Version 1.0
 */
@RestController
@Slf4j
public class PaymentController {

    @Value("${server.port}")
    private String serverPort;

    @GetMapping("/payment/consul")
    public String paymentzk() {
        return "springcloud with consul : " + "\t" + UUID.randomUUID().toString();
    }
}
