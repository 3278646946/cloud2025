package com.atguigu.order.properties;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @version 1.0
 * @Author 盘创铭
 * @Date 2025/3/6 下午7:45
 * @注释
 */
@Data
@Component
@ConfigurationProperties(prefix = "order")  //配置批量绑定在nacos下，无需@RefreshScope就能自动刷新
public class OrderProperties {

    private String timeout;

    private String autoConfirm;

    private String dbUrl;

}
