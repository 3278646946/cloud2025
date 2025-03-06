package com.atguigu.order.service;


import com.atguiu.order.bean.Order;

/**
 * @version 1.0
 * @Author 盘创铭
 * @Date 2025/3/6 下午4:26
 * @注释
 */
public interface OrderService {


    Order createOrder(Long userId, Long productId);


}
