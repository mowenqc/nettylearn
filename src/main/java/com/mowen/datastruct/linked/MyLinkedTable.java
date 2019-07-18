package com.mowen.datastruct.linked;

/***
 * @description : 
 *
 * @author: mowen
 * @create_time: 2019/7/15 17:54
 * @since: v1.0
 */
public class MyLinkedTable<T> implements MyLinkList<T> {
    private int size;
    private Node<T> first;
    private Node<T> last;

    @Override
    public void add(T object) {
        if(first == null){
            first = new Node<>(object);
            last = first;
            size = 1;
        }
        Node<T> node = new Node<>(object);
        node.previous = last;
        last.next = node;
        last = node;
        size++;
    }

    @Override
    public void delete(T object) {
        Node<T> current = first;
        if(first == null){
            return;
        }
        while (current != null){
            if(current.equals(object)){
                Node<T> next = current.next;
                current.next = null;
                if(next != null){
                    next.previous = current.previous;
                }
                if(current.previous != null){
                    current.previous.next = next;
                }
                current.previous = null;
                current = next;
            }
        }
    }

    @Override
    public T get(int index) {
        if(index > size){
            throw new IllegalArgumentException("下标值过大");
        }
        int tmpSize = 0;
        Node<T> current = first;
        while (current != null && tmpSize != index){
            current = current.next;
        }
        return current.data;
    }

    @Override
    public T first() {
        if(first == null){
            return null;
        }
        return first.data;
    }

    @Override
    public T last() {
        if(last == null){
            return null;
        }
        return last.data;
    }
}
