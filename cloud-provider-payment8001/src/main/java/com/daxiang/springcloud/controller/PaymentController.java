package com.daxiang.springcloud.controller;

import com.daxiang.springcloud.entities.CommonResult;
import com.daxiang.springcloud.entities.Payment;
import com.daxiang.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * @ClassName : PaymentController
 * @Description : 支付模块控制类
 * @Author : Daotiger
 * @Date: 2020-04-21 16:33
 * @Version 1.0
 */
@RestController
@Slf4j
@RequestMapping("/payment")
public class PaymentController {
    @Resource
    private PaymentService paymentService;

    @Value("${server.port}")
    private String serverPort;

    @Resource
    private DiscoveryClient discoveryClient;

    @PostMapping
    public CommonResult<Payment> create(@RequestBody Payment payment) {
        int result = paymentService.create(payment);
        log.info("插入结果: " + result);

        if (result > 0) {
            return new CommonResult(200, "插入数据成功serverPort: " + serverPort, result);
        } else {
            return new CommonResult(444, "插入数据失败", null);
        }
    }

    @GetMapping("/{id}")
    public CommonResult<Payment> get(@PathVariable Long id) {
        log.info("此次查询条件id: " + id);
        Payment payment = paymentService.getPaymentById(id);
        log.info("查询结果: " + payment);

        if (payment != null) {

            return new CommonResult(200, "查询数据成功serverPort: " + serverPort, payment);
        } else {
            return new CommonResult(444, "数据不存在", null);
        }
    }

    @GetMapping("/discovery")
    public Object getDiscoveryClient() {

        List<String> services = discoveryClient.getServices();

        for (String service : services) {
            log.info("服务列表: " + service);
        }

        List<ServiceInstance> serviceInstanceList = discoveryClient.getInstances("CLOUD-PROVIDER-SERVICE");

        for (ServiceInstance instance : serviceInstanceList) {
            log.info("服务实例: " + instance.getServiceId() + "\t" + instance.getHost() + "\t" + instance.getPort());
        }
        return this.discoveryClient;
    }

    @GetMapping("/lb")
    public String gePaymentLB() {
        return serverPort;
    }

    @GetMapping("/feign/timeout")
    public String paymentFeignTimeout() {
        try {
            log.info("延迟3S");
            TimeUnit.SECONDS.sleep(3);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return serverPort;
    }
}
