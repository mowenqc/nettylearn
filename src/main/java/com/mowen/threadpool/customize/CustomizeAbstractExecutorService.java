package com.mowen.threadpool.customize;

import java.util.concurrent.Callable;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;
import java.util.concurrent.RunnableFuture;

/***
 * desc  : com.mowen.threadpool.customize
 * author: mowen
 * create_time: 2019/6/4 9:03
 * project_name : mowen_parent
 */
public abstract class CustomizeAbstractExecutorService implements CustomizeExecutorService{

    protected <T> RunnableFuture<T> newTask(Runnable runnable, T value) {
        return new FutureTask<T>(runnable, value);
    }

    protected <T> RunnableFuture<T> newTask(Callable<T> callable) {
        return new FutureTask<T>(callable);
    }

    @Override
    public Future<?> submit(Runnable task) {
        if(task == null){
            throw new IllegalArgumentException("参数错误");
        }
        RunnableFuture<?> futureTask = newTask(task, null);
        execute(futureTask);
        return futureTask;
    }

    @Override
    public <T> Future<T> submit(Runnable task, T result) {
        if(task == null){
            throw new IllegalArgumentException("参数错误");
        }
        RunnableFuture<T> futureTask = newTask(task, result);
        execute(futureTask);
        return futureTask;
    }

    @Override
    public <T> Future<T> submit(Callable<T> task) {
        if(task == null){
            throw new IllegalArgumentException("参数错误");
        }
        RunnableFuture<T> futureTask = newTask(task);
        execute(futureTask);
        return futureTask;
    }

    protected abstract void execute(RunnableFuture futureTask);
}
