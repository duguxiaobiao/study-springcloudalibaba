package com.lonely.service.impl;

import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lonely.dao.StockDao;
import com.lonely.entity.StockPo;
import com.lonely.service.StockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @date: 2022-09-01 13:09
 * @author: ztkj-hzb
 * @description:
 **/
@Service
public class StockServiceImpl extends ServiceImpl<StockDao, StockPo> implements StockService {

    @Autowired
    private StockDao stockDao;

    /**
     * 根据指定商品id删减库存
     *
     * @param shopId
     */
    @Override
    public void reduct(Integer shopId) {
        super.update(new LambdaUpdateWrapper<StockPo>()
                .eq(StockPo::getShopId, shopId)
                .setSql("stock = stock - 1"));
    }
}
