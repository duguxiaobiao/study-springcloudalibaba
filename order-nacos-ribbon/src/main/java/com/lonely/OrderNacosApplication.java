package com.lonely;

import com.ribbon.RibbonRuleConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.netflix.ribbon.RibbonClients;

/**
 * @date: 2022-08-25 17:47
 * @author: ztkj-hzb
 * @description:
 **/
@SpringBootApplication

//使用注解的方式配置负载均衡
/*@RibbonClients(value = {
        @RibbonClient( name = "stock-nacos",configuration = RibbonRuleConfig.class)
})*/
public class OrderNacosApplication {

    public static void main(String[] args) {
        SpringApplication.run(OrderNacosApplication.class, args);
    }


}
