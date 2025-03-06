package com.atguigu.product;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;

import java.util.List;

import static com.alibaba.nacos.api.cmdb.pojo.PreservedEntityTypes.service;

/**
 * @version 1.0
 * @Author 盘创铭
 * @Date 2025/3/6 下午3:11
 * @注释
 */
@SpringBootTest
public class ProTest {

    @Autowired
    public DiscoveryClient discovery;

    @Test
    public void test01(){
        List<String> services = discovery.getServices();
        for (String service : services) {
            for (ServiceInstance instance : discovery.getInstances(service)) {
                System.out.println("服务名："+service+"，服务端口："+instance.getPort()+"服务主机："+instance.getHost());
            }
        }

    }

}
