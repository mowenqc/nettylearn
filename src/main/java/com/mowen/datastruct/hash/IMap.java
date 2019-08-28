package com.mowen.datastruct.hash;

/***
 * @desc  : hash表的基本接口
 * @author: mowen
 * @create_time: 2019/8/9 15:15
 * @since:
 */
public interface IMap<K, V> {

    /**
     * 容量的大小
     * @return
     */
    int size();

    /**
     * 添加元素
     * @param key is not null
     * @param value key
     */
    V put(K key, V value);

    /**
     * 获取key 的值
     * @param key 键
     * @return 值， 如果不存在， 则为Null
     */
    V get(K key);

    /**
     * 删除key的值
     * @param key
     */
    void delete(K key);
}
