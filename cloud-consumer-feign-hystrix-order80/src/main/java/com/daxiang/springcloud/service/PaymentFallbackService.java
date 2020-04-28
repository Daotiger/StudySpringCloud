package com.daxiang.springcloud.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

/**
 * @ClassName : PaymentFallbackService
 * @Description : 统一做降级处理
 * @Author : Daotiger
 * @Date: 2020-04-27 16:01
 * @Version 1.0
 */
@Component
public class PaymentFallbackService implements PaymentHystrixService {

    @Override
    public String paymentInfo_Ok(Integer id) {

        return "----PaymentFallbackService fall back-paymentInfo_OK";
    }

    @Override
    public String paymentInfo_Timeout(Integer id) {

        return "----PaymentFallbackService fall back-paymentInfo_TimeOut";
    }

}
