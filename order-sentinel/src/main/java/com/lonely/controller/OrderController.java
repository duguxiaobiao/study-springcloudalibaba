package com.lonely.controller;

import org.springframework.beans.factory.annotation.Autowired;
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
     * 下单
     *
     * @return
     */
    @GetMapping("/add")
    public String add() {
        //下单
        System.out.println("开始下单");
        return "下单成功";
    }


}
