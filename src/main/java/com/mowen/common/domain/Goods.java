package com.mowen.common.domain;

import java.io.Serializable;
import java.math.BigDecimal;

/***
 * desc  : com.mowen.common.domain
 * author: mowen
 * create_time: 2019/6/6 8:24
 * project_name : mowen_parent
 */
public class Goods implements Serializable {

    private int goodsId;
    private String goodsName;
    private BigDecimal amount;
    private BigDecimal promoteAmount;

    public int getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(int goodsId) {
        this.goodsId = goodsId;
    }

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public BigDecimal getPromoteAmount() {
        return promoteAmount;
    }

    public void setPromoteAmount(BigDecimal promoteAmount) {
        this.promoteAmount = promoteAmount;
    }

    @Override
    public String toString() {
        return "Goods{" +
            "goodsId=" + goodsId +
            ", goodsName='" + goodsName + '\'' +
            ", amount=" + amount +
            ", promoteAmount=" + promoteAmount +
            '}';
    }
}
