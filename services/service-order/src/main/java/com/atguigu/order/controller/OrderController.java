package com.atguigu.order.controller;


import com.atguigu.order.properties.OrderProperties;
import com.atguigu.order.service.OrderService;
import com.atguiu.order.bean.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @version 1.0
 * @Author 盘创铭
 * @Date 2025/3/6 下午4:21
 * @注释
 */
//@RefreshScope
@RestController
public class OrderController {

    @Autowired
    private OrderProperties orderProperties;


    @Autowired
    private OrderService orderService;


    //创建订单
    @GetMapping("/createOrder")
    public Order createOrder(@RequestParam("userId") Long userId,
                             @RequestParam("productId") Long productId){

        return orderService.createOrder(userId, productId);
    }
    @GetMapping("/getConfig")
    public String getConfig(){
//        return orderTimeout+"--"+orderAutoConfirm;

        return "outTime:"+orderProperties.getTimeout()+"  ;  "+
                "autoConfim:"+orderProperties.getAutoConfirm()+"  ;  "+
                "dbUrl:"+orderProperties.getDbUrl();
    }

}
