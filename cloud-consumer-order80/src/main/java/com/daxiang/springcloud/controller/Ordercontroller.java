package com.daxiang.springcloud.controller;

//import com.daxiang. CommonResult;
//import com.daxiang. Payment;

import com.daxiang.springcloud.entities.CommonResult;
import com.daxiang.springcloud.entities.Payment;
import com.daxiang.springcloud.lb.LoadBalancer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.net.URI;
import java.util.List;

/**
 * @ClassName : Ordercontroller
 * @Description : 订单controller类
 * @Author : Daotiger
 * @Date: 2020-04-21 17:24
 * @Version 1.0
 */
@RestController
@Slf4j
public class Ordercontroller {

    //    public static final String PAYMENT_URL = "http://localhost:8001";//单机版
    public static final String PAYMENT_URL = "http://CLOUD-PROVIDER-SERVICE";//集成版

    @Resource
    private RestTemplate restTemplate;

    @Resource
    private DiscoveryClient discoveryClient;

    @Resource
    private LoadBalancer loadBalancer;

    @GetMapping("/index")
    public CommonResult<Payment> defaut() {
        return new CommonResult(200, "ceshi", null);
    }

    @GetMapping("/consumer/index/")
    public CommonResult<Payment> index() {
        return new CommonResult(200, "ceshi", null);
    }

    @GetMapping("/consumer/payments")
    public CommonResult<Payment> creat(Payment payment) {
        return restTemplate.postForObject(PAYMENT_URL + "/payment/", payment, CommonResult.class);
    }

    @GetMapping("/consumer/payment/{id}")
    public CommonResult<Payment> getPayment(@PathVariable("id") Long id) {

        log.info("CommonResult此次查询条件id: " + id);

        return restTemplate.getForObject(PAYMENT_URL + "/payment/" + id + "/", CommonResult.class);
    }

    @GetMapping("consumer/payment/lb")
    public String getPaymentLB() {
        List<ServiceInstance> serviceInstanceList = discoveryClient.getInstances("CLOUD-PROVIDER-SERVICE");

        if (serviceInstanceList == null || serviceInstanceList.size() <= 0) {
            return null;
        }

        ServiceInstance serviceInstance = loadBalancer.INSTANCE(serviceInstanceList);

        URI uri = serviceInstance.getUri();

        log.info("uri: " + uri);

        return restTemplate.getForObject(uri + "/payment/lb", String.class);
    }

}
