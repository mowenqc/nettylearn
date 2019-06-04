package com.mowen.nettyapplication.rpc.service.impl;

import com.mowen.nettyapplication.rpc.domain.Order;
import com.mowen.nettyapplication.rpc.ioc.annotation.Service;
import com.mowen.nettyapplication.rpc.service.IOrderService;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

/***
 * desc  : com.mowen.nettyapplication.rpc.service.impl
 * author: mowen
 * create_time: 2019/6/3 8:40
 * project_name : mowen_parent
 */
@Service
public class OrderService implements IOrderService {

    /**
     * 模拟订单表
     */
    private List<Order> orders = new ArrayList<>();

    @Override
    public Order order(int userId, List<Integer> goodsIds) {
        //没做商品类
        Order order = new Order();
        order.setUserId(userId);
        /**
         * 实际上根据商品信息，优惠券信息等计算订单的支付金额，在这儿模拟写死
         */

        order.setAmount(new BigDecimal(10));
        /**
         * 订单状态通常会用枚举，自定义，在这儿1表示下单，2，支付成功，3,取消订单，4表示退款
         */
        order.setStatus(1);
        order.setCreateTime(new Date());
        /**
         * 根据当前的时间生成一个订单号，作为示例
         */
        order.setOrderSn(Long.toHexString(System.currentTimeMillis()));
        orders.add(order);
        return order;
    }

    @Override
    public List<Order> findUserOrder(int userId) {
        return orders.stream().filter(order -> order.getUserId() == userId).collect(Collectors.toList());
    }

    @Override
    public void updateOrderStatus(String orderSn, int status) {
        orders.forEach(order -> {
            if(order.getOrderSn().equals(orderSn));
            order.setStatus(status);
        });
    }
}
