package com.mowen.threadpool.customize;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/***
 * desc  : com.mowen.threadpool.customize
 * author: mowen
 * create_time: 2019/6/4 8:37
 * project_name : mowen_parent
 */
public class CustomizeThreadFactory implements ThreadFactory {

    private AtomicInteger COUNTER = new AtomicInteger(1);
    @Override
    public Thread newThread(Runnable r) {
        return new CustomizeThread(COUNTER.getAndDecrement(), r);
    }
}
