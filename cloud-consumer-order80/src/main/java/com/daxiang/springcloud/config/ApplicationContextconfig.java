package com.daxiang.springcloud.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @ClassName : ApplicationContextconfig
 * @Description : 配置类
 * @Author : Daotiger
 * @Date: 2020-04-21 17:28
 * @Version 1.0
 */
@Configuration
public class ApplicationContextconfig {
    @Bean
    @LoadBalanced
    public RestTemplate getRestTemplate() {
        return new RestTemplate();
    }
}
