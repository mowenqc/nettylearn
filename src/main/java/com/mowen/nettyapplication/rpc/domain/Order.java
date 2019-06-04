package com.mowen.nettyapplication.rpc.domain;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/***
 * desc  : com.mowen.nettyapplication.rpc.domain， 简版订单实体类
 * author: mowen
 * create_time: 2019/6/3 8:23
 * project_name : mowen_parent
 */
public class Order implements Serializable {

    /**
     * 订单编号
     */
    private String orderSn;

    /**
     * 用户id
     */
    private int userId;

    /**
     * 订单金额
     */
    private BigDecimal amount;

    /**
     * 下单时间
     */
    private Date createTime;

    /**
     * 支付时间
     */
    private Date payTime;

    /**
     * 支付状态
     */
    private int status;

    public String getOrderSn() {
        return orderSn;
    }

    public void setOrderSn(String orderSn) {
        this.orderSn = orderSn;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getPayTime() {
        return payTime;
    }

    public void setPayTime(Date payTime) {
        this.payTime = payTime;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
