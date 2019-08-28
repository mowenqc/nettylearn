package com.mowen.designpattern.structmodel.adapter;

/***
 * @description : 
 *
 * @author: mowen
 * @time: 2019/6/20 20:14
 * @since: v1.0
 */
public interface Action {

    /**
     * 会开火车
     */
    void drive();

    /**
     * 可以走路
     */
    void walk();

    /**
     * 还可以乱跑
     */
    void run();
}
