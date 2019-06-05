package com.mowen.connectionpool.customize;

/***
 * desc  : com.mowen.connectionpool.customize
 * author: mowen
 * create_time: 2019/6/5 11:37
 * project_name : mowen_parent
 */
public interface ObjectPool<T> {

    /**
     * 获取对象
     * @return
     */
    T borrowObject();

    /**
     *  返回对象到对象池
     * @param t
     */
    void returnObject(T t);
}
