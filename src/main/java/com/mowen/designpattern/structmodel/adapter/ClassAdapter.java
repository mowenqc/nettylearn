package com.mowen.designpattern.structmodel.adapter;

/***
 * @description : 
 * 类适配器， people是待适配的对象， action是适配的目标，
 * 这样就将待适配的对象扩展了带有目标的功能
 * 目标也有了待适配对象的功能
 * 通常在源于目标有重叠功能时
 * @author: mowen
 * @time: 2019/6/20 20:15
 * @since: v1.0
 */
public class ClassAdapter extends People implements Action {

    @Override
    public void walk() {
        System.out.println("这个人在步行");
    }

    @Override
    public void run() {
        System.out.println("这个人在跑步~");
    }

    public static void main(String[] args) {
        Action action = new ClassAdapter();
        action.drive();
        action.run();
        action.walk();

        People people = new ClassAdapter();
        ((ClassAdapter) people).run();
        people.drive();
        ((ClassAdapter) people).walk();
    }
}
