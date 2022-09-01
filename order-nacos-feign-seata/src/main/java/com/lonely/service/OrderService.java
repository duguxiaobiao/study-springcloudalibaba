package com.lonely.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.lonely.entity.OrderPo;

/**
 * @date: 2022-09-01 13:09
 * @author: ztkj-hzb
 * @description:
 **/
public interface OrderService extends IService<OrderPo> {

    /**
     * 下单
     */
    void add(OrderPo orderPo);


}
