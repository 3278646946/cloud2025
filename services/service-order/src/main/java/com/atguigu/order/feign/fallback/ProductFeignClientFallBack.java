package com.atguigu.order.feign.fallback;

import com.atguigu.order.feign.ProductFeignClient;
import com.atguiu.product.bean.Product;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

/**
 * @version 1.0
 * @Author 盘创铭
 * @Date 2025/3/7 下午4:47
 * @注释
 */
@Component
public class ProductFeignClientFallBack implements ProductFeignClient {

    //接口中的 getProductInfo  兜底方法！
    @Override
    public Product getProductInfo(Long id) {
        Product product = new Product();
        product.setId(1L);
        product.setProductName("FALL_BACK!!");
        product.setPrice(new BigDecimal("0.00"));
        product.setNum(0);
        return product;
    }
}
