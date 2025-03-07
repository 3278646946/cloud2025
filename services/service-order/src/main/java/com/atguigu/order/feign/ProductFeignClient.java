package com.atguigu.order.feign;

import com.atguigu.order.feign.fallback.ProductFeignClientFallBack;
import com.atguiu.product.bean.Product;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @version 1.0
 * @Author 盘创铭
 * @Date 2025/3/7 下午2:02
 * @注释
 */
//feign客户端  发送远程调用的客户端 对接第三方api,需要用到固定地址，使用参数url
@FeignClient(value = "service-product",fallback = ProductFeignClientFallBack.class)
public interface ProductFeignClient {

    //mvc注解的两套使用逻辑
    // 1.标注在Controller上，是接收请求
    // 2.标注在FeignClient上，是发送请求
    @GetMapping("/product/{productId}")
    Product getProductInfo(@PathVariable("productId") Long id);




}
