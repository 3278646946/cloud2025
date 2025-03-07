package com.atguigu.order;

import com.alibaba.cloud.nacos.NacosConfigManager;
import com.alibaba.nacos.api.config.ConfigService;
import com.alibaba.nacos.api.config.listener.Listener;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

/**
 * @version 1.0
 * @Author 盘创铭
 * @Date 2025/3/5 下午10:44
 * @注释
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients  //开启feign远程调用功能
public class MainOrder{

    @Value("${server.port}")
    private  String serverport;

    public static void main(String[] args) {
        SpringApplication.run(MainOrder.class,args);
    }
    @PostConstruct
    public void init() {
        System.out.println(serverport + ": 订单微服务已启动...");
    }
    @Bean
    ApplicationRunner applicationRunner(NacosConfigManager manager){
        return args -> {
            ConfigService configService = manager.getConfigService();
            configService.addListener("service-order.yml", "DEFAULT_GROUP", new Listener() {
                @Override
                public Executor getExecutor() {
                    return Executors.newFixedThreadPool(4);
                }

                @Override
                public void receiveConfigInfo(String configInfo) {
                    System.out.println("configInfo = " + configInfo);
                }
            });
        };
    }

}
