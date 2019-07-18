package com.mowen.datastruct.array;

import java.util.Collection;

/***
 * @description : 
 *
 * @author: mowen
 * @create_time: 2019/7/17 21:29
 * @since: v1.0
 */
public interface MyList<T>  {

    void add(T object);

    void delete(T object);

    void batchDelete(Collection<T> collection);

    void set(int index, T o);

    T get(int index);
}
