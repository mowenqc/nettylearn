package com.mowen.datastruct.hash;

import java.util.Objects;

/***
 * @desc  : 实现一个hash 的map结构， 一个简单的Map， 如果hash碰撞，采用链表的形式存储
 * @author: mowen
 * @create_time: 2019/8/9 16:27
 * @since:
 */
public class MyHashMap<K, V> implements IMap<K, V> {

    private Object [] elementData;

    private int size = 0;
    private double threshold = .75;

    @Override
    public int size() {
        return size;
    }

    @Override
    public V put(K key, V value) {
        Objects.requireNonNull(key);
        ensureCapacity();
        int hash = hash(key);
        int position = hash%elementData.length;
        Entity entity = (Entity)elementData[position];
        Entity<K, V> kvEntity = new Entity<>(key, value);
        if(entity == null){
            elementData[position] = kvEntity;
            return value;
        }
        else {
            do{
                if(hash == hash(entity.key)){
                    V v = (V)entity.value;
                    entity.value = value;
                    return v;
                }
                if(entity.next != null){
                    entity  = entity.next;
                }
            }
            while (entity.next != null);
            entity.next = kvEntity;
            return value;
        }
    }

    @Override
    public V get(K key) {
        Objects.requireNonNull(key);
        int hash = hash(key);
        int position = getPosition(key);
        Entity<K, V> entity = (Entity<K, V>)elementData[position];
        if(entity == null){
            return null;
        }
        while (entity != null){
            if(entity.key.equals(key)){
                return entity.value;
            }
            entity = entity.next;
        }
        return null;
    }

    @Override
    public void delete(K key) {
        //key不为空
        Objects.requireNonNull(key);
        int position = getPosition(key);
        Entity<K, V> entity = (Entity<K, V>)elementData[position];
        if(entity == null){
            return;
        }
        boolean isHead = true;
        if(entity.next == null && entity.key.equals(key)){
            elementData[position] = null;
            return;
        }
        Entity previous = entity;
        while (entity != null){
            if(entity.key.equals(key)){
                if(isHead){
                    elementData[position] = entity.next;
                    entity.next = null;
                }
                else {
                    //可能存在问题， 没有深入验证，只是做个演示， 讲解一个hash
                    previous.next = entity.next;
                    return;
                }

                return;
            }
            isHead = false;
            previous = entity;
            entity = entity.next;
        }

    }

    private int getPosition(K key) {
        int hash = hash(key);
        return hash%elementData.length;
    }

    /**
     * 简单的用Object.hashCode()的生成策略， 因为K是一个泛型，比较难以自我实现
     * @param key
     * @return
     */
    private int hash(Object key){
        return key.hashCode();
    }
    private void ensureCapacity(){
        //保证数组的大小
    }
    private class Entity<K, V>{
        K key;
        V value;

        Entity<K, V> next;

        public Entity(K key, V value){
            this.key = key;
            this.value = value;
        }

        public K getKey() {
            return key;
        }

        public void setKey(K key) {
            this.key = key;
        }

        public V getValue() {
            return value;
        }

        public void setValue(V value) {
            this.value = value;
        }

        public Entity<K, V> getNext() {
            return next;
        }

        public void setNext(Entity<K, V> next) {
            this.next = next;
        }
    }
}
