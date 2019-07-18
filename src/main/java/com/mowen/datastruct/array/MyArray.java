package com.mowen.datastruct.array;

import java.util.Collection;

/***
 * @description :数组的基本实现
 * @author: mowen
 * @create_time: 2019/7/15 17:53
 * @since: v1.0
 */
public class MyArray<T> implements MyList<T> {

    private static int defaultSize = 10;
    Object[] elementData;
    private int size;

    public MyArray(){
        elementData = new Object[10];
        size = 0;
    }
    @Override
    public void add(T object) {
        ensureCapacity();
    }

    private void ensureCapacity(){
        if(elementData.length > size + 1){
            return;
        }
        int currentSize = elementData.length;
        if(currentSize == 0){
            currentSize = defaultSize;
        }
        int newSize = currentSize << 1;
        System.out.println(newSize);
        Object [] newArray = new Object[newSize];
        if(size > 0){
            System.arraycopy(elementData, 0, newArray,0, size);
        }
        elementData = newArray;
    }
    @Override
    public void delete(T object) {
        if(size == 0){
            return;
        }
        int tmpSize = 0;
        Object [] objects = new Object[elementData.length];
        for (Object o : objects) {
            if(o == null){
                if(object != null){
                    objects[tmpSize++] = o;
                }
            }
            else if(object == null){
                objects[tmpSize++] = o;
            }
            else if(!o.equals(object)) {
                objects[tmpSize++] = o;
            }
        }
        elementData = objects;
        size = tmpSize;
    }

    @Override
    public void batchDelete(Collection<T> collection) {
        //和单个删除做法类似
    }

    @Override
    public void set(int index, T o) {
        if(index > elementData.length){
            throw new IllegalArgumentException("下标过大");
        }
        if(o == null && elementData[index] == null){
            return;
        }
        if(o != null && elementData[index] == null){

            size ++;
        }
        elementData[index] = o;
    }

    @Override
    public T get(int index) {
        if(index > elementData.length){
            throw new IllegalArgumentException("下标过大");
        }
        return (T) elementData[index];
    }
}
