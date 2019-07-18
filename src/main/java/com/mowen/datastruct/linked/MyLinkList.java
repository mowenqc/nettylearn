package com.mowen.datastruct.linked;

/***
 * @description : 链表结构的基本方法
 * @author: mowen
 * @create_time: 2019/7/18 10:24
 * @since: v1.0
 */
public interface MyLinkList<T> {
    void add(T object);

    void delete(T object);

    /**
     * 获取元素
     * @param index
     * @return
     */
    T get(int index);

    T first();

    T last();
}
