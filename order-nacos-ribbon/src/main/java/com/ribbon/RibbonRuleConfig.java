package com.ribbon;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @date: 2022-08-29 12:59
 * @author: ztkj-hzb
 * @description: ribbon rule配置类 不能被conponengscan扫描到，不然就是全局使用
 **/
@Configuration
public class RibbonRuleConfig {


    /**
     * iRule:该名字不能变
     * 设置策略为随机
     *
     * @return
     */
    @Bean
    public IRule iRule() {
        return new RandomRule();
    }


}
