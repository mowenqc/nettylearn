package com.mowen.designpattern.buildmodel.factory.model;

/***
 * @description : 
 *
 * @author: mowen
 * @time: 2019/6/20 18:08
 * @since: v1.0
 */
public class Saler extends Employee {

    @Override
    public void action() {
        System.out.println(getName() + "我正在与客户沟通~~");
    }
}