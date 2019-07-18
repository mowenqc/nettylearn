package com.mowen.datastruct.linked;

import java.util.Objects;

/***
 * @description :链表数据结构的定义， 双向链表
 * @author: mowen
 * @create_time: 2019/7/18 8:23
 * @since: v1.0
 */
class Node<T> {

    /**
     * 链表中的数据
     */
    T data;

    /**
     * 前一个数据节点
     */
    Node previous;

    /**
     * 后一个数据节点
     */
    Node next;

    public Node(T data){
        this.data = data;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()){
            return false;
        }
        Node<?> node = (Node<?>) o;
        return data.equals(node.data);
    }

    @Override
    public int hashCode() {
        return Objects.hash(data);
    }
}
