package com.daxiang.springcloud.lb;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @ClassName : MyLB
 * @Description : 自定义负载均衡
 * @Author : Daotiger
 * @Date: 2020-04-24 17:30
 * @Version 1.0
 */
@Slf4j
@Component
public class MyLB implements LoadBalancer {

    private AtomicInteger atomicInteger = new AtomicInteger(0);

    public final int getAndIncrement() {
        int current;
        int next;
        do {
            current = this.atomicInteger.get();
            next = current >= 2147483647 ? 0 : current + 1;//2147483647最大整数
        } while (!this.atomicInteger.compareAndSet(current, next));
        log.info("*******第几次调用: " + next);
        return next;
    }

    @Override
    public ServiceInstance INSTANCE(List<ServiceInstance> serviceInstanceList) {

        int index = getAndIncrement() % serviceInstanceList.size();

        return serviceInstanceList.get(index);
    }
}
