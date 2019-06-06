package com.mowen.common.service;

import com.mowen.common.domain.Coupon;

/***
 * desc  : com.mowen.dynamicproxylearn.service
 * author: mowen
 * create_time: 2019/6/6 8:21
 * project_name : mowen_parent
 */
public interface ICouponService {

    Coupon findCouponById(int id);
}
