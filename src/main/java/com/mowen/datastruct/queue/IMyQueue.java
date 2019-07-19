package com.mowen.datastruct.queue;

/***
 * @description : 
 * @author: mowen
 * @create_time: 2019/7/19 8:47
 * @since: v1.0
 */
public interface IMyQueue<T> {

    void put(T t);

    T get();

    T take();
}
