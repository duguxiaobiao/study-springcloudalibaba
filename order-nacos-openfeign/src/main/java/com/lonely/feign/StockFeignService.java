package com.lonely.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @date: 2022-08-29 15:41
 * @author: ztkj-hzb
 * @description: 库存服务 feign接口
 **/
@FeignClient(name = "stock-nacos", path = "/stock")
public interface StockFeignService {


    /**
     * 扣减库存
     *
     * @return
     */
    @GetMapping("/reduct")
    String reduct();


}
