package com.mowen.connectionpool.customize;

import com.mowen.common.Constants;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/***
 * desc  : com.mowen.connectionpool.customize
 * author: mowen
 * create_time: 2019/6/5 11:23
 * project_name : mowen_parent
 */
public abstract class CustomizeAbstractObjectPool<T> implements ObjectPool<T>{

    private int poolSize = Constants.TEN;
    private BlockingQueue<T> idleQueue = new LinkedBlockingQueue<>();
    private Set<T> workObject = new HashSet<>();

    private AtomicInteger borrowCount = new AtomicInteger(Constants.ZERO);

    private Lock borrowLock = new ReentrantLock();
    private Lock returnLock = new ReentrantLock();

    private AbstractObjectFactory<T> objectFactory = null;

    public CustomizeAbstractObjectPool(AbstractObjectFactory objectFactory){
        this.objectFactory = objectFactory;
        initObject();
    }

    private void initObject(){
        for (int i = 0; i < poolSize; i++){
            idleQueue.offer(objectFactory.createObject());
        }
    }
    @Override
    public T borrowObject() {
        try {
            T t = idleQueue.poll(100, TimeUnit.SECONDS);
            if(t != null){
                borrowCount.getAndIncrement();
                try {
                    borrowLock.lock();
                    workObject.add(t);
                } finally {
                    borrowLock.unlock();
                }
            }
            return t;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void returnObject(T t) {
        if(t == null){
            return;
        }
        try {
            returnLock.lock();
            workObject.remove(t);
            borrowCount.getAndDecrement();
        }
        finally {
            returnLock.unlock();
            idleQueue.offer(t);
        }
    }
}
