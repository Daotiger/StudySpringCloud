package com.daxiang.springcloud.controller;

import com.daxiang.springcloud.entities.CommonResult;
import com.daxiang.springcloud.entities.Payment;
import com.daxiang.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @ClassName : PaymentController
 * @Description : 支付模块控制类
 * @Author : Daotiger
 * @Date: 2020-04-21 16:33
 * @Version 1.0
 */
@RestController
@Slf4j
public class PaymentController {
    @Resource
    private PaymentService paymentService;

    @PostMapping("/payment")
    public CommonResult<Payment> create(@RequestBody Payment payment) {
        int result = paymentService.create(payment);
        log.info("插入结果: " + result);

        if (result > 0) {
            return new CommonResult(200, "插入数据成功", result);
        } else {
            return new CommonResult(444, "插入数据失败", null);
        }
    }

    @GetMapping("/payment/{id}")
    public CommonResult<Payment> get(@PathVariable Long id) {
        log.info("此次查询条件id: " + id);
        Payment payment = paymentService.getPaymentById(id);
        log.info("查询结果: " + payment);

        if (payment != null) {

            return new CommonResult(200, "查询数据成功", payment);
        } else {
            return new CommonResult(444, "数据不存在", null);
        }
    }

}
