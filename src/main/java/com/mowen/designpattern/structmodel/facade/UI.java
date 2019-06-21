package com.mowen.designpattern.structmodel.facade;

/***
 * @description : 
 *
 * @author: mowen
 * @time: 2019/6/21 14:45
 * @since: v1.0
 */
public class UI implements Worker {

    @Override
    public void start() {
        System.out.println("设计师开始设计图");
    }

    @Override
    public void finish() {
        System.out.println("设计师设计完成");
    }
}
