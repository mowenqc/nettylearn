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
        System.out.println("驾驶");
    }

    @Override
    public void walk() {
        System.out.println("走路");
    }

    @Override
    public void run() {
        System.out.println("奔跑大家都会，蜗牛都可以狂奔");
    }

    @Override
    public void fly() {
        System.out.println("可能会飞了~");
    }
}
