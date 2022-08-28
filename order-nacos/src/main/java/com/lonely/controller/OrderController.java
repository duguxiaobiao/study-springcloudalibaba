package com.lonely.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @date: 2022-08-25 17:46
 * @author: ztkj-hzb
 * @description:
 **/
@RestController
@RequestMapping("/order")
public class OrderController {


    /**
     * 通过服务名称调用
     */
    @Autowired
    private RestTemplate restTemplate;

    /**
     * 下单
     *
     * @return
     */
    @GetMapping("/add")
    public String add() {

        //下单
        System.out.println("开始下单");

        //扣减库存
        String url = "http://stock-nacos/stock/reduct";
        String result = this.restTemplate.getForObject(url, String.class);

        return "下单成功" + result;
    }


}
