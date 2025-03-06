package com.atguigu.product.controller;


import com.atguigu.product.service.ProductService;
import com.atguiu.product.bean.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @version 1.0
 * @Author 盘创铭
 * @Date 2025/3/6 下午3:42
 * @注释
 */
@RestController
public class ProductController {
    //注入service
    @Autowired
    private ProductService productService;

    @GetMapping("/product/{productId}")
    //获取商品信息
    public Product getProductInfo(@PathVariable(value = "productId") Long productId) {
        return productService.getProductById(productId)  ;
    }


}
