package com.lonely;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @date: 2022-08-25 17:47
 * @author: ztkj-hzb
 * @description:
 **/
@SpringBootApplication
@EnableTransactionManagement
@MapperScan(basePackages = "com.lonely.dao")
@EnableFeignClients
public class OrderNacosFeignSeataApplication {

    public static void main(String[] args) {
        SpringApplication.run(OrderNacosFeignSeataApplication.class, args);
    }


}
