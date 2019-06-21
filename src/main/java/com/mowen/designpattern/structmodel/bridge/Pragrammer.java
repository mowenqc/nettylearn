package com.mowen.designpattern.structmodel.bridge;

/***
 * @description : 
 *
 * @author: mowen
 * @time: 2019/6/21 15:45
 * @since: v1.0
 */
public class Pragrammer implements IWorker {

    @Override
    public void doWork() {
        System.out.println("初级程序员正在写bug~");
    }
}
