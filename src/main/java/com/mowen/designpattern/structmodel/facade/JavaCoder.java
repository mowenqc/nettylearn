package com.mowen.designpattern.structmodel.facade;

/***
 * @description : 
 *
 * @author: mowen
 * @time: 2019/6/21 14:46
 * @since: v1.0
 */
public class JavaCoder implements Worker {

    @Override
    public void start() {
        System.out.println("后端java开始设计代码~");
    }

    @Override
    public void finish() {
        System.out.println("后端开发完成");
    }
}
