package com.mowen.designpattern.buildmodel.factory.model;

/***
 * @description : 
 *
 * @author: mowen
 * @time: 2019/6/20 18:09
 * @since: v1.0
 */
public class Programmer extends Employee {

    @Override
    public void action() {
        System.out.println("苦逼的程序员正在写bug~");
    }
}
