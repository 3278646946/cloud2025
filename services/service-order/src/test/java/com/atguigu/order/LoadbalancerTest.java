package com.atguigu.order;

import com.alibaba.nacos.shaded.io.grpc.LoadBalancer;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;

/**
 * @version 1.0
 * @Author 盘创铭
 * @Date 2025/3/6 下午6:27
 * @注释
 */
@SpringBootTest
public class LoadbalancerTest {

    @Autowired
    private LoadBalancerClient loadBalancerclient;

    @Test
    public void testLoadBalancer() {
        ServiceInstance choose = loadBalancerclient.choose("service-product");// 要获取的服务名
        System.out.println("choose = " + choose+", host = " + choose.getHost() + ", port = " + choose.getPort() + ", uri = " + choose.getUri()  );
        choose = loadBalancerclient.choose("service-product");
        System.out.println("choose = " + choose+", host = " + choose.getHost() + ", port = " + choose.getPort() + ", uri = " + choose.getUri()  );
        choose = loadBalancerclient.choose("service-product");
        System.out.println("choose = " + choose+", host = " + choose.getHost() + ", port = " + choose.getPort() + ", uri = " + choose.getUri()  );
        choose = loadBalancerclient.choose("service-product");
        System.out.println("choose = " + choose+", host = " + choose.getHost() + ", port = " + choose.getPort() + ", uri = " + choose.getUri()  );
        choose = loadBalancerclient.choose("service-product");
        System.out.println("choose = " + choose+", host = " + choose.getHost() + ", port = " + choose.getPort() + ", uri = " + choose.getUri()  );
        choose = loadBalancerclient.choose("service-product");
        System.out.println("choose = " + choose+", host = " + choose.getHost() + ", port = " + choose.getPort() + ", uri = " + choose.getUri()  );
        choose = loadBalancerclient.choose("service-product");
        System.out.println("choose = " + choose+", host = " + choose.getHost() + ", port = " + choose.getPort() + ", uri = " + choose.getUri()  );



    }


}
