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
    private int position;

    public MyStack(){
        position = -1;
        elementData = new Object[10];
    }

    @Override
    public void push(T t) {
        if(t == null){
            throw new IllegalArgumentException("入栈的元素不能为空");
        }
        ensureCapacity();
        elementData[position++] = t;
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
            return t;
        }
        return null;
    }
}
