package com.daxiang.springcloud.service.impl;

import com.daxiang.springcloud.dao.PaymentDao;
import com.daxiang.springcloud.entities.Payment;
import com.daxiang.springcloud.service.PaymentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @ClassName : PaymentServiceImpl
 * @Description : 支付service实现类
 * @Author : Daotiger
 * @Date: 2020-04-21 16:27
 * @Version 1.0
 */
@Service
public class PaymentServiceImpl implements PaymentService {

    @Resource
    PaymentDao paymentDao;

    /**
     * 创建一个支付
     *
     * @param payment
     * @return
     */
    @Override
    public int create(Payment payment) {
        return paymentDao.create(payment);
    }

    /**
     * 读取一条支付记录
     *
     * @param id
     * @return
     */
    @Override
    public Payment getPaymentById(Long id) {
        return paymentDao.getPaymentById(id);
    }
}
