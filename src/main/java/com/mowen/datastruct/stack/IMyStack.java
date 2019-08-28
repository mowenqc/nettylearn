package com.mowen.datastruct.stack;

/***
 * @description : 
 * @author: mowen
 * @create_time: 2019/7/18 11:11
 * @since: v1.0
 */
public interface IMyStack<T> {

    /**
     * 如栈操作
     * @param t 入栈的数据
     */
    void push(T t);

    /**
     * 获取栈顶的数据，如果存在就返回
     * @return t
     */
    T pull();

    /**
     * 获取栈顶的数据，同时删除栈顶的元素
     * 如果不存在则返回空
     * @return t
     */
    T pop();

    /**
     * 时候满栈
     * @return
     */
    boolean isFull();

    /**
     * 时候为空
     * @return
     */
    boolean isEmpty();
}
