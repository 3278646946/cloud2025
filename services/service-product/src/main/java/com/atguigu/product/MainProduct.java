package com.atguigu.product;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @version 1.0
 * @Author 盘创铭
 * @Date 2025/3/5 下午11:23
 * @注释
 */
@SpringBootApplication
public class MainProduct {
    @Value("${server.port}")
    private String serverport;

    public static void main(String[] args) {
        SpringApplication.run(MainProduct.class,args);
    }
    @PostConstruct
    public void init() {
        System.out.println(serverport + ": 产品微服务已启动...");
    }
}
