package com.mowen.dynamicproxy;

/***
 * desc  : com.mowen.dynamicproxylearn.cglib
 * author: mowen
 * create_time: 2019/6/6 13:56
 * project_name : mowen_parent
 */
public interface DynamicProxy<T> {

    T proxy() throws IllegalAccessException, InstantiationException;
}
