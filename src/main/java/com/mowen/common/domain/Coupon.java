package com.mowen.common.domain;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/***
 * desc  : com.mowen.common.domain
 * author: mowen
 * create_time: 2019/6/6 8:26
 * project_name : mowen_parent
 */
public class Coupon implements Serializable {

    private int couponId;
    private String couponName;
    private BigDecimal deduce;
    private BigDecimal condition;
    private Date useStartTime;
    private Date useEndTime;

    public int getCouponId() {
        return couponId;
    }

    public void setCouponId(int couponId) {
        this.couponId = couponId;
    }

    public String getCouponName() {
        return couponName;
    }

    public void setCouponName(String couponName) {
        this.couponName = couponName;
    }

    public BigDecimal getDeduce() {
        return deduce;
    }

    public void setDeduce(BigDecimal deduce) {
        this.deduce = deduce;
    }

    public BigDecimal getCondition() {
        return condition;
    }

    public void setCondition(BigDecimal condition) {
        this.condition = condition;
    }

    public Date getUseStartTime() {
        return useStartTime;
    }

    public void setUseStartTime(Date useStartTime) {
        this.useStartTime = useStartTime;
    }

    public Date getUseEndTime() {
        return useEndTime;
    }

    public void setUseEndTime(Date useEndTime) {
        this.useEndTime = useEndTime;
    }

    @Override
    public String toString() {
        return "Coupon{" +
            "couponId=" + couponId +
            ", couponName='" + couponName + '\'' +
            ", deduce=" + deduce +
            ", condition=" + condition +
            ", useStartTime=" + useStartTime +
            ", useEndTime=" + useEndTime +
            '}';
    }
}
