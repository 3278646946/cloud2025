package com.atguigu.order;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @version 1.0
 * @Author 盘创铭
 * @Date 2025/3/5 下午10:44
 * @注释
 */
@SpringBootApplication
@EnableDiscoveryClient
public class MainOrder{
    public static void main(String[] args) {
        SpringApplication.run(MainOrder.class,args);
        System.out.println("${server.port} : 订单微服务已启动...");
    }

}
