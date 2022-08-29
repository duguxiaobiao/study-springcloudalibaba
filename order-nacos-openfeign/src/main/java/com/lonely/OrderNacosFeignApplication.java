package com.lonely;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @date: 2022-08-25 17:47
 * @author: ztkj-hzb
 * @description:
 **/
@SpringBootApplication
@EnableFeignClients
public class OrderNacosFeignApplication {

    public static void main(String[] args) {
        SpringApplication.run(OrderNacosFeignApplication.class, args);
    }


}
