package com.mowen.datastruct.queue;

import com.mowen.datastruct.AbstractList;
import com.mowen.datastruct.Node;

/***
 * @description : 
 * @author: mowen
 * @create_time: 2019/7/19 8:49
 * @since: v1.0
 */
public class MyQueue<T> extends AbstractList implements IMyQueue<T> {
    //队列头
    private Node<T> head;
    //队尾
    private Node<T> tail;

    //队列容量
    private int size;

    @Override
    public void put(T t) {
        Node<T> node = new Node<>(t);
        if(head == null){
            head = node;
            tail = node;
            return;
        }
        if(head == tail){
            head.next = node;
            node.previous = head;
            tail = node;
            return;
        }
        tail.next = node;
        node.previous = tail;
        tail = node;
    }

    @Override
    public T get() {
        return head.data;
    }

    @Override
    public T take() {
        if(head == null){
            return null;
        }
        T t = head.data;
        if(head == tail){
            head = null;
            tail = null;
            return t;
        }
        head = head.next;
        head.previous = null;
        return t;
    }

    @Override
    public int size() {
        return size;
    }
}
