package com.mowen.datastruct.tree;

/***
 * @desc  :  树行结构的operate定义
 * @author: mowen
 * @create_time: 2019/8/9 17:41
 * @since:
 */
public interface ITree<T  extends Comparable> {

    /**
     * 插入t元素在合适的位置
     * @param t
     */
    void insert(T t);

    /**
     * 获取树中的t，如果存在则返回
     * @param t
     * @return
     */
    T get(T t);

    /**
     * 删除树种的t元素
     * @param t
     */
    void delete(T t);

    int size();
}
