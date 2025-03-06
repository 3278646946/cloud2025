package com.atguigu.product.service;


import com.atguiu.product.bean.Product;

/**
 * @version 1.0
 * @Author 盘创铭
 * @Date 2025/3/6 下午3:50
 * @注释
 */
public interface ProductService {

    /**
     * 获取单个商品
     *
     * @return 单个商品
     */
    Product getProductById(Long productId);
}
