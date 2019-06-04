package com.mowen.threadpool.jdk;

import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/***
 * desc  : com.mowen.threadpool.jdk
 * author: mowen
 * create_time: 2019/6/3 13:59
 * project_name : mowen_parent
 */
public class TheadPoolExcutorTest {

    public static void main(String[] args) {
        /**
         * 几个核心的参数参照源码介绍
         * corePoolSize， 一直存活的线程数，即使没有线程在执行
         * maximumPoolSize， 最大线程数
         * keepAliveTime： 新线程等待时间
         * unit：时间单位 TimeUnit类型
         * workQueue：等待队列
         * threadFactory： 线程工厂，可以自定义，继承ThreadFactory就可以
         */
        ThreadPoolExecutor poolExecutor = new ThreadPoolExecutor(2, 5, 1, TimeUnit.MILLISECONDS, new LinkedBlockingQueue<>());
        for (int i = 0 ; i < 10000; i++){
            poolExecutor.submit(new MyTask(i));
        }
        //初始化的工作也就几个局部变量的设置， 可以简单了解一下这几个局部变量的意义
        //毕竟是别人实现的，看看思路， 对自己的代码有什么参考意义
        /**
         * 关键来看submit后，线程是怎么调度的, 所有的submit都是用的这个方法
         * RunnableFuture<T> ftask = newTaskFor(task, result);
         * execute(ftask);
         * protected <T> RunnableFuture<T> newTaskFor(Runnable runnable, T value) {
         *         return new FutureTask<T>(runnable, value);
         * }newTaskFor只是简单的构建一个FutureTask， 很好理解
         */
        /**
         * 在来看execute(ftask);这是整个线程的核心内容, 分为三个步骤， 源码上的注释写的比较清楚
         int c = ctl.get();
         if (workerCountOf(c) < corePoolSize) {
            if (addWorker(command, true))
             return;
            c = ctl.get();
         }
         if (isRunning(c) && workQueue.offer(command)) {
            int recheck = ctl.get();
            if (! isRunning(recheck) && remove(command))
                reject(command);
            else if (workerCountOf(recheck) == 0)
                addWorker(null, false);
         }
         else if (!addWorker(command, false))
            reject(command);
         */

    }

}
