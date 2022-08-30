package com.lonely.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @date: 2022-08-30 15:58
 * @author: ztkj-hzb
 * @description: 动态刷新 @Value 的值
 **/
@RestController
@RequestMapping("/refresh")
@RefreshScope
public class RefreshController {

    /**
     * 单纯使用 ${} 方式无法获取最新的值，但是使用 Environment 可以
     * 如果想要 ${} 方式也可以，需要添加注解 @RefreshScope
     */
    @Value("${user.name}")
    private String userName;

    @Autowired
    private Environment environment;

    @GetMapping("/refresh")
    public String refresh() {
        return userName + environment.getProperty("user.name");
    }


}
