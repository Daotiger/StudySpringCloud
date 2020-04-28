package com.daxiang.springcloud.service;

import cn.hutool.core.util.IdUtil;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import jdk.internal.org.objectweb.asm.tree.TryCatchBlockNode;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.concurrent.TimeUnit;

/**
 * @ClassName : PaymentService
 * @Description : 服务类
 * @Author : Daotiger
 * @Date: 2020-04-27 14:27
 * @Version 1.0
 */
@Service
public class PaymentService {

    /**
     * 模拟正常访问
     *
     * @param id
     * @return
     */
    public String paymentInfo_Ok(Integer id) {
        return "线程池: " + Thread.currentThread().getName() + " paymentInfo_Ok, id: " + id + "\t";
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
    @HystrixCommand(fallbackMethod = "paymentInfo_TimeoutHandler", commandProperties = {
            //设置这个线程的超时时间是3s，3s内是正常的业务逻辑，超过3s调用fallbackMethod指定的方法进行处理
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "5000")
    })
    public String paymentInfo_Timeout(Integer id) {
        int timeNumber = 3;
        //int timeNumber = 5;//模拟超时
//        int age = 10 / 0;//模拟异常
        try {
            TimeUnit.SECONDS.sleep(timeNumber);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return "线程池: " + Thread.currentThread().getName() + " 访问时间过长但是成功返回paymentInfo_Timeout, id: " + id + "\t";
    }

    public String paymentInfo_TimeoutHandler(Integer id) {

        return "线程池: " + Thread.currentThread().getName() + " 系统繁忙或运行出错,请稍后再试, id: " + id + "\t";
    }

    //======服务熔断
    @HystrixCommand(
            fallbackMethod = "paymentCircuitBreaker_FailBack",
            commandProperties = {
                    @HystrixProperty(name = "circuitBreaker.enabled", value = "true"),   //是否开启断路器
                    @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold", value = "10"),  //请求次数,当在配置时间窗口内达到此数量的失败后，进行短路。默认20个
                    @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds", value = "10000"),    //时间窗口期,短路多久以后开始尝试是否恢复，默认5s
                    @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage", value = "60"),    //出错百分比阈值，当达到此阈值后，开始短路。默认50%
            })
    public String paymentCircuitBreaker(@PathVariable("id") Integer id) {
        if (id < 0) {
            throw new RuntimeException("*****id 不能负数*****");
        }

        String serialNumber = IdUtil.simpleUUID();

        return Thread.currentThread().getName() + "\t" + "调用成功, 流水号: " + serialNumber;
    }

    public String paymentCircuitBreaker_FailBack(@PathVariable("id") Integer id) {
        return "id 不能负数, 请稍后再试. id: " + id;
    }
}
