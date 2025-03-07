package com.atguigu.product.service.impl;

import com.atguigu.product.service.ProductService;
import com.atguiu.product.bean.Product;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.concurrent.TimeUnit;

/**
 * @version 1.0
 * @Author 盘创铭
 * @Date 2025/3/6 下午3:50
 * @注释
 */
@Service
public class ProductServiceImpl implements ProductService {
    @Override
    public Product getProductById(Long productId) {
        Product product = new Product();
        product.setId(productId);
        product.setProductName("测试商品");
        product.setPrice(BigDecimal.valueOf(100));
        product.setNum(100);
        try {
            TimeUnit.SECONDS.sleep(63);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return product;
    }
}
