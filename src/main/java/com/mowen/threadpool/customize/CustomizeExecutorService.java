package com.mowen.threadpool.customize;

import java.util.concurrent.Callable;
import java.util.concurrent.Future;

/***
 * desc  : com.mowen.threadpool.customize
 * author: mowen
 * create_time: 2019/6/4 8:57
 * project_name : mowen_parent
 */
public interface CustomizeExecutorService {

    /**
     * 提交任务
     * @param task
     * @return
     */
    Future<?> submit(Runnable task);

    <T> Future<T> submit(Runnable task, T result);

    <T> Future<T> submit(Callable<T> task);

    /**
     * 关闭线程池
     */
    void shutdown();

}
