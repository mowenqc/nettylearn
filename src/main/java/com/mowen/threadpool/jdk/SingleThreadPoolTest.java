package com.mowen.threadpool.jdk;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/***
 * desc  : com.mowen.threadpool.jdk
 * author: mowen
 * create_time: 2019/6/4 7:30
 * project_name : mowen_parent
 */
public class SingleThreadPoolTest {

    public static void main(String[] args) {
        /**
         * 单线程线程池， 也就是说线程池中只有一个线程是正在执行的
         */
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        for (int i = 0 ; i < 10000; i++){
            executorService.submit(new MyTask(i));
        }
        executorService.shutdown();
        /**
         * 用的是ThreadPoolExecutor
         * public static ExecutorService newSingleThreadExecutor() {
         *         return new FinalizableDelegatedExecutorService
         *             (new ThreadPoolExecutor(1, 1,
         *                                     0L, TimeUnit.MILLISECONDS,
         *                                     new LinkedBlockingQueue<Runnable>()));
         *     }
         *     只需要主要这是一个LinkedBlockingQueue队列就可以，理解了ThreadPoolExecutor，对这个工具类的理解就没有什么问题
         *     稍微的看一下FinalizableDelegatedExecutorService，
         *     static class FinalizableDelegatedExecutorService
         *         extends DelegatedExecutorService {
         *         FinalizableDelegatedExecutorService(ExecutorService executor) {
         *             super(executor);
         *         }
         *         protected void finalize() {
         *             super.shutdown();
         *         }
         *     }
         *     真正执行的还是new ThreadPoolExecutor(1, 1,
         *                                     0L, TimeUnit.MILLISECONDS,
         *                                     new LinkedBlockingQueue<Runnable>())
         *     可以看到FinalizableDelegatedExecutorService 继承自DelegatedExecutorService，点击去看看DelegatedExecutorService
         *     static class DelegatedExecutorService extends AbstractExecutorService
         *     AbstractExecutorService是抽象类的一个实现
         */
    }
}
