package com.mowen.common.service;

import com.mowen.common.domain.Order;
import java.util.List;

/***
 * desc  : com.mowen.nettyapplication.rpc.service
 * author: mowen
 * create_time: 2019/6/3 8:37
 * project_name : mowen_parent
 */
public interface IOrderService {

    /**
     * 下单
     * @param goodsIds 商品id
     * @return
     */
    Order order(int userId, List<Integer> goodsIds);

    /**
     * 获取用户订单
     * @param userId
     * @return
     */
    List<Order> findUserOrder(int userId);

    /**
     * 更新订单的状态
     * @param orderSn
     * @param status
     */
    void updateOrderStatus(String orderSn, int status);

}
