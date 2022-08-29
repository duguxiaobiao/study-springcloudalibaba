package com.lonely.config;

import com.lonely.interceptors.CustomFeignInterceptor;
import feign.Logger;
import feign.Request;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.concurrent.TimeUnit;

/**
 * @date: 2022-08-29 16:04
 * @author: ztkj-hzb
 * @description: feign相关配置
 **/

//添加 @Configuration 是全局生效，也可以单个处理，如果是单个处理，则这里不能添加 @Configuration 注解，然后在 @FeignClient中配置config属性
@Configuration
public class FeignConfig {


    /**
     * 设置feign的调用日志(基于debug日志)
     *
     * @return
     */
    @Bean
    public Logger.Level feignLoggerLevel() {
        //显示调用的完整日志
        return Logger.Level.FULL;
    }


    /**
     * 设置openfeign 超时时间
     *
     * @return
     */
    @Bean
    public Request.Options options() {
        return new Request.Options(2, TimeUnit.SECONDS, 3, TimeUnit.SECONDS, true);
    }


    /**
     * 自定义拦截器
     *
     * @return
     */
    @Bean
    public CustomFeignInterceptor customFeignInterceptor() {
        return new CustomFeignInterceptor();
    }


}
