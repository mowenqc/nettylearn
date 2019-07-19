package com.mowen.datastruct;

/***
 * @description : 
 * @author: mowen
 * @create_time: 2019/7/18 13:33
 * @since: v1.0
 */
public abstract class AbstractList {

    /**
     * 动态扩展容量
     */
    protected  void ensureCapacity(){
        //扩充容量
    }

    public abstract int size();
}
