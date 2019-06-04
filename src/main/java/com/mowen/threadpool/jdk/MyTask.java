package com.mowen.threadpool.jdk;

import org.apache.log4j.Logger;

/***
 * desc  : com.mowen.threadpool.jdk
 * author: mowen
 * create_time: 2019/6/3 14:37
 * project_name : mowen_parent
 */
public class MyTask implements Runnable {

    private Logger logger = Logger.getLogger(getClass());
    private int i = 0;
    public MyTask(int i){
        this.i = i;
    }
    @Override
    public void run() {
        logger.info("执行任务--------------- " + i);
    }
}
