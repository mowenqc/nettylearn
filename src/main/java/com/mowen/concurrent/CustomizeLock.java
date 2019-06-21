package com.mowen.concurrent;

import java.util.concurrent.locks.AbstractQueuedSynchronizer;

/***
 * desc  : com.mowen.concurrentlearn
 * author: mowen
 * create_time: 2019/6/6 14:48
 * project_name : mowen_parent
 */
public class CustomizeLock {

    /**
     * 非常简单的一个锁
     */
    private Aync aync = new Aync();
    public void lock(){
        aync.tryAcquire(1);
    }
    public void unlock(){
        aync.tryRelease(1);
    }

    public class Aync extends AbstractQueuedSynchronizer {
        @Override
        protected boolean tryAcquire(int arg) {
            //自旋锁
            for (;;){
                if (compareAndSetState(0, 1)) {//state为0才设置为1，不可重入！
                    setExclusiveOwnerThread(Thread.currentThread());//设置为当前线程独占资源
                    return true;
                }
            }
        }

        @Override
        protected boolean tryRelease(int arg) {
            if (getState() == 0)//既然来释放，那肯定就是已占有状态了。只是为了保险，多层判断！
            {
                throw new IllegalMonitorStateException();
            }
            setExclusiveOwnerThread(null);
            setState(0);//释放资源，放弃占有状态
            return true;
        }
    }
}
