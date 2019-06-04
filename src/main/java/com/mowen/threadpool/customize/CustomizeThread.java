package com.mowen.threadpool.customize;

import org.apache.log4j.Logger;

/***
 * desc  : com.mowen.threadpool.customize
 * author: mowen
 * create_time: 2019/6/4 8:38
 * project_name : mowen_parent
 */
public class CustomizeThread extends Thread {

    private Logger logger = Logger.getLogger(getName());

    private int id;
    public CustomizeThread(int id, Runnable runnable){
        super(runnable);
        this.id = id;
    }

    @Override
    public synchronized void start() {
        logger.info("开始执行线程：" + id);
        super.start();
        logger.info("线程id=" + id + "执行完毕~");
    }
}
