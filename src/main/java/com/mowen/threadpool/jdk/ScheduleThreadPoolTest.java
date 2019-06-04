package com.mowen.threadpool.jdk;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/***
 * desc  : com.mowen.threadpool.jdk
 * author: mowen
 * create_time: 2019/6/4 7:46
 * project_name : mowen_parent
 */
public class ScheduleThreadPoolTest {

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newScheduledThreadPool(10);
        for (int i = 0 ; i < 10000; i++){
            executorService.submit(new MyTask(i));
        }
        executorService.shutdown();
        /**
         * public static ScheduledExecutorService newScheduledThreadPool(int corePoolSize) {
         *         return new ScheduledThreadPoolExecutor(corePoolSize);
         *     }
         * public class ScheduledThreadPoolExecutor
         *         extends ThreadPoolExecutor
         *         implements ScheduledExecutorService
         * ScheduledThreadPoolExecutor 是ThreadPoolExecutor的一个实现，增加ScheduledExecutorService计划，相当于采用了策略模式，适配器模式
         * 在ScheduledExecutorService定义了一组计划，ScheduledThreadPoolExecutor中实现，基本的操作仍然是ExecutorService， 这个自带线程池的基础
         * public ScheduledThreadPoolExecutor(int corePoolSize) {
         *         super(corePoolSize, Integer.MAX_VALUE, 0, NANOSECONDS,
         *               new DelayedWorkQueue());
         *     }
         *     采用的是DelayedWorkQueue延迟队列， 这就好理解了
         */
    }
}
