package com.lonely.controller;

import com.lonely.service.StockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @date: 2022-08-25 17:50
 * @author: ztkj-hzb
 * @description:
 **/
@RestController
@RequestMapping("/stock")
public class StockController {

    @Autowired
    private StockService stockService;

    /**
     * 扣减库存
     *
     * @return
     */
    @GetMapping("/reduct/{shopId}")
    public String reduct(@PathVariable("shopId") Integer shopId) {
        this.stockService.reduct(shopId);
        return "扣减成功";
    }


}
