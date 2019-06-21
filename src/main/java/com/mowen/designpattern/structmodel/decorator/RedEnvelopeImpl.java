package com.mowen.designpattern.structmodel.decorator;

/***
 * @description : 
 *
 * @author: mowen
 * @time: 2019/6/21 9:12
 * @since: v1.0
 */
public class RedEnvelopeImpl implements RedEnvelope {

    @Override
    public void getMoney() {
        System.out.println("通用开始抢红包");
    }
}
