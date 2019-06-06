package com.mowen.common.service.impl;

import com.mowen.common.domain.Coupon;
import com.mowen.common.service.ICouponService;
import java.math.BigDecimal;
import java.util.Calendar;
import java.util.Date;

/***
 * desc  : com.mowen.common.service.impl
 * author: mowen
 * create_time: 2019/6/6 8:23
 * project_name : mowen_parent
 */
public class CouponServiceImpl implements ICouponService {

    @Override
    public Coupon findCouponById(int id) {
        Coupon coupon = new Coupon();
        coupon.setCouponId(id);
        coupon.setCondition(new BigDecimal(100));
        coupon.setDeduce(new BigDecimal(10));
        coupon.setCouponName("满100减10代金局");
        coupon.setUseStartTime(new Date());
        /**
         * 当前时间到延期15天
         */
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.DAY_OF_MONTH, calendar.get(Calendar.DAY_OF_MONTH) + 15);
        coupon.setUseEndTime(calendar.getTime());
        return coupon;
    }
}
