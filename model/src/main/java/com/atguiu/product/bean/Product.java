package com.atguiu.product.bean;

import lombok.Data;

import java.math.BigDecimal;

/**
 * @version 1.0
 * @Author 盘创铭
 * @Date 2025/3/6 下午3:44
 * @注释
 */
@Data
public class Product {
    private Long id;
    private String productName;
    private BigDecimal price;
    private int num;
}
