package com.daxiang.springcloud.service;

import org.springframework.stereotype.Service;

/**
 * @ClassName : PaymentFallbackService
 * @Description : 服务类
 * @Author : Daotiger
 * @Date: 2020-04-27 16:01
 * @Version 1.0
 */
//@Service
//public class PaymentFallbackService implements PaymentHystrixService {
public class PaymentFallbackService {

    //    @Override
    public String paymentInfo_OK(Integer id) {
        return "----PaymentFallbackService fall back-paymentInfo_OK,o(╥﹏╥)o";
    }

    //    @Override
    public String paymentInfo_TimeOut(Integer id) {
        return "----PaymentFallbackService fall back-paymentInfo_TimeOut,o(╥﹏╥)o";
    }
}
