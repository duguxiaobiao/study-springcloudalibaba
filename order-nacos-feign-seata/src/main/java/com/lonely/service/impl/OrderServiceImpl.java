package com.lonely.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lonely.dao.OrderDao;
import com.lonely.entity.OrderPo;
import com.lonely.feign.StockFeignService;
import com.lonely.service.OrderService;
import io.seata.spring.annotation.GlobalTransactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @date: 2022-09-01 13:09
 * @author: ztkj-hzb
 * @description:
 **/
@Service
public class OrderServiceImpl extends ServiceImpl<OrderDao, OrderPo> implements OrderService {

    @Autowired
    private OrderDao orderDao;


    @Autowired
    private StockFeignService stockFeignService;


    /**
     * 下单
     *
     * @param orderPo
     */
    @Override
    //@Transactional
    @GlobalTransactional
    public void add(OrderPo orderPo) {

        //下单
        super.save(orderPo);

        //删减库存
        this.stockFeignService.reduct(orderPo.getShopId());

        System.out.println(1/0);

    }
}
