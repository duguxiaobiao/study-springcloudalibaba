package com.lonely.controller;

import com.lonely.entity.OrderPo;
import com.lonely.feign.StockFeignService;
import com.lonely.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @date: 2022-08-25 17:46
 * @author: ztkj-hzb
 * @description:
 **/
@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private OrderService orderService;


    /**
     * 下单
     *
     * @return
     */
    @GetMapping("/add")
    public String add() {

        //下单
        System.out.println("开始下单");

        OrderPo orderPo = new OrderPo();
        orderPo.setShopId(1);
        orderPo.setShopName("水果-香蕉");
        this.orderService.add(orderPo);

        return "下单成功";
    }


}
