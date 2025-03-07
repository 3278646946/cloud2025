package com.atguigu.order.config;

import feign.Logger;
import feign.Retryer;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;


/**
 * @version 1.0
 * @Author 盘创铭
 * @Date 2025/3/6 下午6:04
 * @注释
 */
@Configuration
public class OrderConfig {


    // 声明一个RestTemplate bean，实现远程调用功能功能
    @Bean
    @LoadBalanced   //注解式负载均衡
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }


    //配置Feign日志记录
    @Bean
    Logger.Level feignLoggerLevel() {
        return Logger.Level.FULL;  // 记录Feign所有请求的细节
    }


    //配置Feign重试机制
    @Bean
    public Retryer Retry() {
        return new  Retryer.Default();
    }


}
