package com.atguiu.order.bean;

import com.atguiu.product.bean.Product;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

/**
 * @version 1.0
 * @Author 盘创铭
 * @Date 2025/3/6 下午4:23
 * @注释
 */
@Data
public class Order {
    private Long orderId;
    private BigDecimal totalAmount;
    private Long userId;
    private String nickName;
    private String address;
    private List<Product> products;
}
