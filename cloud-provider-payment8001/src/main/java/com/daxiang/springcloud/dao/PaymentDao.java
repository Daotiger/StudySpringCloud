package com.daxiang.springcloud.dao;

import com.daxiang.springcloud.entities.Payment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @ClassName : PaymentDao
 * @Description : 支付dao类
 * @Author : Daotiger
 * @Date: 2020-04-21 16:05
 * @Version 1.0
 */
@Mapper
public interface PaymentDao {
    //创建
    public int create(Payment payment);

    //读取
    public Payment getPaymentById(@Param("id") Long id);

}
