package com.mowen.datastruct.stack;

import com.mowen.datastruct.AbstractList;

/***
 * @description :  栈的实现
 * @author: mowen
 * @create_time: 2019/7/18 13:27
 * @since: v1.0
 */
public class MyStack<T> extends AbstractList implements IMyStack<T> {

    Object [] elementData;

    /**
     * 数组的当前栈顶的位置
     */
    private int position;

    /**
     * 栈的元素的个数
     */
    private int size;

    /**
     * 栈的最大容量
     */
    private int capacity;

    public MyStack(){
        position = -1;
        size = 0;
        elementData = new Object[10];
    }

    @Override
    public void push(T t) {
        if(t == null){
            throw new IllegalArgumentException("入栈的元素不能为空");
        }
        ensureCapacity();
        elementData[position++] = t;
        size++;
    }

    @Override
    public T pull() {
        if(position >= 0){
            return (T) elementData[position];
        }
        return null;
    }

    @Override
    public T pop() {
        if(position >= 0){
            T t = (T) elementData[position];
            elementData[position] = null;
            position--;
            size--;
            return t;
        }
        return null;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isFull() {
        return size >= capacity;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }
}
