package com.lonely.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

/**
 * @date: 2022-09-01 13:08
 * @author: ztkj-hzb
 * @description:
 **/
@Data
@TableName("t_order")
public class OrderPo implements Serializable {

    /**
     * id
     */
    @TableId(type = IdType.AUTO)
    private Integer id;

    /**
     * 商品id
     */
    private Integer shopId;

    /**
     * 商品名称
     */
    private String shopName;


}
