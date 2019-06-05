package com.mowen.connectionpool.customize;

/***
 * desc  : com.mowen.connectionpool.customize
 * author: mowen
 * create_time: 2019/6/5 11:03
 * project_name : mowen_parent
 */
public interface AbstractObjectFactory<T> {

    T createObject();
}
