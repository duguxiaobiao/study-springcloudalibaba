package com.lonely.interceptors;

import feign.RequestInterceptor;
import feign.RequestTemplate;
import lombok.extern.slf4j.Slf4j;

/**
 * @date: 2022-08-29 17:05
 * @author: ztkj-hzb
 * @description: feign拦截器
 **/
@Slf4j
public class CustomFeignInterceptor implements RequestInterceptor {


    @Override
    public void apply(RequestTemplate requestTemplate) {

        //添加请求头信息
        requestTemplate.header("token", "xxxxxx");

        //添加日志
        log.info("调用了自定义feign拦截器");

    }
}
