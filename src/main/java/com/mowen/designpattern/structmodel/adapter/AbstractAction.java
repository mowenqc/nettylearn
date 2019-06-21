package com.mowen.designpattern.structmodel.adapter;

/***
 * @description : 
 *
 * @author: mowen
 * @time: 2019/6/20 20:29
 * @since: v1.0
 */
public class AbstractAction implements Action, HighAction {

    @Override
    public void drive() {

    }

    @Override
    public void walk() {

    }

    @Override
    public void run() {

    }

    @Override
    public void fly() {
        System.out.println("可能会飞了~");
    }
}
