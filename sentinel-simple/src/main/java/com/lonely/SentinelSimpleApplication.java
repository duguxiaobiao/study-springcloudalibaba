package com.lonely;

import com.alibaba.csp.sentinel.annotation.aspectj.SentinelResourceAspect;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

/**
 * @date: 2022-08-25 17:47
 * @author: ztkj-hzb
 * @description: sentinel的简单使用
 **/
@SpringBootApplication
public class SentinelSimpleApplication {

    public static void main(String[] args) {
        SpringApplication.run(SentinelSimpleApplication.class, args);
    }

}
