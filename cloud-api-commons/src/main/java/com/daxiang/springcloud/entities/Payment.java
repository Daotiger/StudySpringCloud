package com.daxiang.springcloud.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @ClassName : Payment
 * @Description : 支付实体类
 * @Author : Daotiger
 * @Date: 2020-04-21 15:55
 * @Version 1.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Payment implements Serializable {

    private Long id;
    /**
     * 流水号
     */
    private String serial;
}
