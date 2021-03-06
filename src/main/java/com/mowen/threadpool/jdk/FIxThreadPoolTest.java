package com.mowen.threadpool.jdk;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/***
 * desc  : com.mowen.threadpool.jdk
 * author: mowen
 * create_time: 2019/6/4 7:30
 * project_name : mowen_parent
 */
public class FIxThreadPoolTest {

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        for (int i = 0 ; i < 10000; i++){
            executorService.submit(new MyTask(i));
        }
        executorService.shutdown();
        /**
         * 用的是ThreadPoolExecutor
         * public static ExecutorService newCachedThreadPool() {
         *         return new ThreadPoolExecutor(0, Integer.MAX_VALUE,
         *                                       60L, TimeUnit.SECONDS,
         *                                       new LinkedBlockingQueue<Runnable>());
         *     }
         *     只需要主要这是一个LinkedBlockingQueue队列就可以，理解了ThreadPoolExecutor，对这个工具类的理解就没有什么问题
         */
    }
}
