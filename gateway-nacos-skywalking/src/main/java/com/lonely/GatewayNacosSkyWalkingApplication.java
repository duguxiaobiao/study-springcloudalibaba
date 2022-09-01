package com.lonely;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @date: 2022-08-25 17:47
 * @author: ztkj-hzb
 * @description: 在启动参数中添加如下参数：
 * -javaagent:/Users/huangzhibiao/Software/Java/apache-skywalking-8.4.0/agent/skywalking-agent.jar
 * -DSW_AGENT_NAME=skywalking-demo
 * -DSW_AGENT_COLLECTOR_BACKEND_SERVICES=localhost:11800
 *
 *
 **/
@SpringBootApplication
public class GatewayNacosSkyWalkingApplication {

    public static void main(String[] args) {
        SpringApplication.run(GatewayNacosSkyWalkingApplication.class, args);
    }


}
