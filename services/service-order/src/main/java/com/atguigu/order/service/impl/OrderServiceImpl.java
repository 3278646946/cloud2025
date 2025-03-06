package com.atguigu.order.service.impl;

import com.atguigu.order.service.OrderService;
import com.atguiu.order.bean.Order;
import com.atguiu.product.bean.Product;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @version 1.0
 * @Author 盘创铭
 * @Date 2025/3/6 下午4:27
 * @注释
 */
@Service
@Slf4j
public class OrderServiceImpl implements OrderService {

    @Autowired
    private DiscoveryClient  discoveryClient;

    @Autowired
    private LoadBalancerClient loadBalancerClient;

    @Autowired
    private RestTemplate restTemplate;

    @Override
    public Order createOrder(Long userId, Long productId) {
        Product productFromRemote = getProductFromRemoteLoadBalancerClient(productId);

        Order order = new Order();
        order.setOrderId(1L);
        //总金额
        order.setTotalAmount(productFromRemote.getPrice().multiply(new  BigDecimal(productFromRemote.getNum())));
        order.setUserId(userId);
        order.setNickName("zhangsan");
        order.setAddress("尚硅谷");
        //远程调用商品列表
        order.setProducts(Arrays.asList(productFromRemote));
        return order;

    }

    // 基于注解的负载均衡
    public Product getProductFromRemoteLoadBalancerClient(Long productId) {

        // http://localhost:9000/product/1

        String URL = "http://service-product/product/" + productId;
        // service-product 会被动态替换
        log.info("远程调用：{}", URL);
        // 通过RestTemplate 发送远程调用。
        return restTemplate.getForObject(URL, Product.class, productId);
    }




    public Product getProductFromRemote(Long productId) {

        //1.获取商品服务所在的所有机器IP+Port
        //List<ServiceInstance> instances = discoveryClient.getInstances("service-product");

        // 采用负载均衡方式远程调用
        ServiceInstance choose = loadBalancerClient.choose("service-product");

        // http://localhost:9000/product/1
        String URL = "http://" + choose.getHost()+":" + choose.getPort() + "/product/" + productId;
        log.info("远程调用：{}", URL);
        // 通过RestTemplate 发送远程调用。
        return restTemplate.getForObject(URL, Product.class, productId);
    }
}
