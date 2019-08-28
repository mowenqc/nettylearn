package com.mowen.datastruct.queue;

/***
 * @description : 队列操作的定义
 * @author: mowen
 * @create_time: 2019/7/19 8:47
 * @since: v1.0
 */
public interface IMyQueue<T> {

    /**
     * 插入元素到对尾
     * @param t
     */
    void put(T t);

    /**
     * 获取对头元素
     * @return
     */
    T get();

    /**
     * 获取对头元素，
     * @return
     */
    T take();
}
