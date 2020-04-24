package com.daxiang.myrule;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @ClassName : MySelfRule
 * @Description : 规则
 * @Author : Daotiger
 * @Date: 2020-04-24 16:00
 * @Version 1.0
 */
@Configuration
public class MySelfRule {

    @Bean
    public IRule myRule() {
        //手动选着规则,定义为随机
        //默认是轮询
        return new RandomRule();
    }
}
