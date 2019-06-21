package com.mowen.designpattern.structmodel.bridge;

/***
 * @description : 
 *
 * @author: mowen
 * @time: 2019/6/21 15:19
 * @since: v1.0
 */
public abstract class Bridge {

    private IWorker worker;

    public IWorker getWorker(){
        return worker;
    }

    public void setWorker(IWorker worker) {
        this.worker = worker;
    }

    public void doString(){
        worker.doWork();
    }
}
