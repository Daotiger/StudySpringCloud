package com.daxiang.springcloud.service;

import com.daxiang.springcloud.entities.Payment;
import org.apache.ibatis.annotations.Param;

/**
 * @ClassName : Payment
 * @Description : 支付服务类
 * @Author : Daotiger
 * @Date: 2020-04-21 16:24
 * @Version 1.0
 */
public interface PaymentService {
    /**
     * 创建一个支付
     *
     * @param payment
     * @return
     */
    public int create(Payment payment);

    /**
     * 读取一条支付记录
     *
     * @param id
     * @return
     */
    public Payment getPaymentById(@Param("id") Long id);
}
