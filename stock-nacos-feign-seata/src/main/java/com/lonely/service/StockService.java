package com.lonely.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.lonely.entity.StockPo;

/**
 * @date: 2022-09-01 13:09
 * @author: ztkj-hzb
 * @description:
 **/
public interface StockService extends IService<StockPo> {


    /**
     * 根据指定商品id删减库存
     *
     * @param shopId
     */
    void reduct(Integer shopId);

}
