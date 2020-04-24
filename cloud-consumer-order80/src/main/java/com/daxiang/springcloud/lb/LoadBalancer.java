package com.daxiang.springcloud.lb;

import org.springframework.cloud.client.ServiceInstance;

import java.util.List;

/**
 * 负载均衡接口
 */
public interface LoadBalancer {

    public ServiceInstance INSTANCE(List<ServiceInstance> serviceInstanceList);
}
