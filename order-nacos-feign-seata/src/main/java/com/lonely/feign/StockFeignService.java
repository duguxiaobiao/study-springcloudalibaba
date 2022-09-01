package com.lonely.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @date: 2022-09-01 14:00
 * @author: ztkj-hzb
 * @description:
 **/
@FeignClient(name = "stock-nacos-feign-seata",path = "/stock")
public interface StockFeignService {

    /**
     * 扣减库存
     *
     * @return
     */
    @GetMapping("/reduct/{shopId}")
    String reduct(@PathVariable("shopId") Integer shopId);


}
