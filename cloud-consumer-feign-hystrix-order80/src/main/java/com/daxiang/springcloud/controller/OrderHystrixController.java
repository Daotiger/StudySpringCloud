package com.daxiang.springcloud.controller;

import cn.hutool.core.util.IdUtil;
import com.daxiang.springcloud.service.PaymentHystrixService;
import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.concurrent.TimeUnit;

/**
 * @ClassName : OrderHystrixController
 * @Description : 控制类
 * @Author : Daotiger
 * @Date: 2020-04-27 16:05
 * @Version 1.0
 */
@RestController
@Slf4j
//@DefaultProperties(defaultFallback = "payment_Global_FallBackMethod")
public class OrderHystrixController {

    @Resource
    private PaymentHystrixService paymentHystrixService;

    @GetMapping("/consumer/payment/hystrix/ok/{id}")
    public String paymentInfo_Ok(@PathVariable("id") Integer id) {
        return paymentHystrixService.paymentInfo_Ok(id);
    }

    /**
     * @param id
     * @return
     * @Author Daotiger
     * @Description 模拟超时3s
     * @HystrixCommand报异常后如何处理： 一旦调用服务方法失败并抛出了错误信息后，
     * 会自动调用@HystrixCommand标注好的fallbackMethod调用类中的指定方法
     * @Date 11:32
     */
    @GetMapping("/consumer/payment/hystrix/timeout/{id}")
//    @HystrixCommand(fallbackMethod = "paymentInfo_TimeoutHandler", commandProperties = {
//            //设置这个线程的超时时间是3s，3s内是正常的业务逻辑，超过3s调用fallbackMethod指定的方法进行处理
//            @HystrixProperty(name="execution.isolation.thread.timeoutInMilliseconds",value = "1500")
//    })//与全局降级冲突
//    @HystrixCommand
    public String paymentInfo_Timeout(@PathVariable("id") Integer id) {

//        int age = 10 / 0;
        String result = paymentHystrixService.paymentInfo_Timeout(id);

        return result;
    }

    public String paymentInfo_TimeoutHandler(@PathVariable("id") Integer id) {

        return "我是消费者80,系统繁忙或运行出错,请稍后再试, id: " + id + "\t";
    }

    //下面是全局fallback方法
    //全局的不能写参数
    public String payment_Global_FallBackMethod() {
        return "Global异常处理信息,请稍后再试!" + "\t";
    }

}
