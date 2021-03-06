package com.daxiang.springcloud.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

/**
 * @ClassName : PaymentController
 * @Description : 控制层
 * @Author : Daotiger
 * @Date: 2020-04-23 17:47
 * @Version 1.0
 */
@RestController
@Slf4j
@RequestMapping("/payment")
public class PaymentController {

    @Value("${server.port}")
    private String serverPort;

    @GetMapping("/zk")
    public String paymentzk() {
        return "springcloud with zookeeper : " + "\t" + UUID.randomUUID().toString();
    }
}
