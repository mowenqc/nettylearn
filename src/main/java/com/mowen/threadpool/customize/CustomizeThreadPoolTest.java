package com.mowen.threadpool.customize;

import com.mowen.threadpool.jdk.MyTask;

/***
 * desc  : com.mowen.threadpool.customize
 * author: mowen
 * create_time: 2019/6/4 17:21
 * project_name : mowen_parent
 */
public class CustomizeThreadPoolTest {

    public static void main(String[] args) {
        CustomizeThreadPool executorService = new CustomizeThreadPool();
        for (int i = 0 ; i < 10000; i++){
            executorService.submit(new MyTask(i));
        }
        System.out.println("finish");
        executorService.shutdown();
        System.out.println("完成");
    }
}
