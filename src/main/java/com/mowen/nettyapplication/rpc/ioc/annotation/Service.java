package com.mowen.nettyapplication.rpc.ioc.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/***
 * desc  : com.mowen.nettyapplication.rpc.ioc.annotation
 * author: mowen
 * create_time: 2019/6/2 15:51
 * project_name : mowen_parent
 */
@Inherited
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE})
public @interface Service {
    String value = "";
}
