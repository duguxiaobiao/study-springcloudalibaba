package com.lonely.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @date: 2022-08-25 17:50
 * @author: ztkj-hzb
 * @description:
 **/
@RestController
@RequestMapping("/stock")
public class StockController {


    /**
     * 扣减库存
     * @return
     */
    @GetMapping("/reduct")
    public String reduct() {
        return "扣减成功";
    }


}
