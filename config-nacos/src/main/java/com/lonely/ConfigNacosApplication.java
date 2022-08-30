package com.lonely;

import lombok.SneakyThrows;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.concurrent.TimeUnit;

/**
 * @date: 2022-08-25 17:47
 * @author: ztkj-hzb
 * @description:
 **/
@SpringBootApplication
public class ConfigNacosApplication {

    @SneakyThrows
    public static void main(String[] args) {
        ConfigurableApplicationContext configurableApplicationContext = SpringApplication.run(ConfigNacosApplication.class, args);

        while (true) {
            String userName = configurableApplicationContext.getEnvironment().getProperty("user.name");
            String userAge = configurableApplicationContext.getEnvironment().getProperty("user.age");
            String userAddress = configurableApplicationContext.getEnvironment().getProperty("user.address");
            String redisHost = configurableApplicationContext.getEnvironment().getProperty("redis.host");
            System.out.printf("userName: %s,userAge: %s,userAddress: %s,redisHost: %s", userName, userAge,userAddress,redisHost);
            System.out.println();
            TimeUnit.SECONDS.sleep(1);
        }
    }


}
