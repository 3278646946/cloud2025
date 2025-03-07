package com.atguigu.order.interceptor;

import feign.RequestInterceptor;
import feign.RequestTemplate;
import org.springframework.stereotype.Component;

import java.util.UUID;

/**
 * @version 1.0
 * @Author 盘创铭
 * @Date 2025/3/7 下午4:27
 * @注释
 */
@Component
public class XTokenRequestInterceptor implements RequestInterceptor {

    /**
     * 请求拦截器
     * @param requestTemplate  请求模版
     */
    @Override
    public void apply(RequestTemplate requestTemplate) {
        System.out.println("拦截器成功启动");
        requestTemplate.header("X-Token", UUID.randomUUID().toString());

    }
}
