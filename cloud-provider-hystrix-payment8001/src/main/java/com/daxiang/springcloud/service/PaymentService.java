package com.daxiang.springcloud.service;

import jdk.internal.org.objectweb.asm.tree.TryCatchBlockNode;
import org.springframework.stereotype.Service;

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
     * 模拟超时3s
     *
     * @param id
     * @return
     */
    public String paymentInfo_Timeout(Integer id) {
        int timeNumber = 3;
        try {
            TimeUnit.SECONDS.sleep(timeNumber);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return "线程池: " + Thread.currentThread().getName() + " paymentInfo_Timeout, id: " + id + "\t";
    }
}
