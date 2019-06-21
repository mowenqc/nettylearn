package com.mowen.designpattern.structmodel.facade;

/***
 * @description : 
 *
 * @author: mowen
 * @time: 2019/6/21 14:44
 * @since: v1.0
 */
public class ProductManager implements Worker {

    @Override
    public void start() {
        System.out.println("产品经理开始设计产品，原型，需求");
    }

    @Override
    public void finish() {
        System.out.println("产品工作完成");
    }
}
