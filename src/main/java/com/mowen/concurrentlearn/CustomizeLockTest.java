package com.mowen.concurrentlearn;

import java.util.concurrent.atomic.AtomicInteger;

/***
 * desc  : com.mowen.concurrentlearn
 * author: mowen
 * create_time: 2019/6/6 16:16
 * project_name : mowen_parent
 */
public class CustomizeLockTest {


    public static void main(String[] args) {
        CustomizeLock customizeLock = new CustomizeLock();
        Thread thread1 = new Thread(new MyTask(customizeLock), "thread-A");
        thread1.start();
        Thread thread2 = new Thread(new MyTask(customizeLock), "thead-B");
        thread2.start();
    }

    public static class MyTask implements Runnable{

        private CustomizeLock customizeLock;
        public MyTask(CustomizeLock customizeLock){
            this.customizeLock = customizeLock;
        }

        @Override
        public void run() {
            try {
                System.out.println("执行线程" + Thread.currentThread().getName());
                customizeLock.lock();
                System.out.println(Thread.currentThread().getName() + "获取到锁");
                Thread.sleep(10000);
                System.out.println("执行完线程" + Thread.currentThread().getName());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            finally {
                customizeLock.unlock();
            }
        }
    }
}
