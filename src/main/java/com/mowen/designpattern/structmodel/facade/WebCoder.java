package com.mowen.designpattern.structmodel.facade;

/***
 * @description : 
 *
 * @author: mowen
 * @time: 2019/6/21 14:41
 * @since: v1.0
 */
public class WebCoder implements Worker {

    @Override
    public void start() {
        System.out.println("前端工程师开始工作");
    }

    @Override
    public void finish() {
        System.out.println("前端工作完成~");
    }

}
