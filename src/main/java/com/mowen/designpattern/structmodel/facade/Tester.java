package com.mowen.designpattern.structmodel.facade;

/***
 * @description : 
 *
 * @author: mowen
 * @time: 2019/6/21 14:47
 * @since: v1.0
 */
public class Tester implements Worker {

    @Override
    public void start() {
        System.out.println("项目提交测试");
    }

    @Override
    public void finish() {
        System.out.println("测试完成，上线，运维发布");
    }
}
