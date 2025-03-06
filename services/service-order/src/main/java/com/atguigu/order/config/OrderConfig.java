package com.atguigu.order.config;

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

    @Bean
    @LoadBalanced   //注解式负载均衡
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
