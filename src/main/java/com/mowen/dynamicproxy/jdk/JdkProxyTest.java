package com.mowen.dynamicproxy.jdk;

import com.mowen.common.domain.Coupon;
import com.mowen.common.service.ICouponService;
import com.mowen.common.service.impl.CouponServiceImpl;

/***
 * desc  : com.mowen.dynamicproxylearn.jdk
 * author: mowen
 * create_time: 2019/6/6 9:36
 * project_name : mowen_parent
 */
public class JdkProxyTest {

    public static void main(String[] args) {

        ICouponService proxy =  new ProxyIncocationHandler<ICouponService>(new CouponServiceImpl()).getProxy();
        Coupon coupon = proxy.findCouponById(1);
        System.out.println(coupon);
    }
}
