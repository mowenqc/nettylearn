package com.mowen.designpattern.actionmodel.observer;

import java.util.Map;
import java.util.Map.Entry;

/***
 * @description : 
 *
 * @author: mowen
 * @time: 2019/6/25 14:47
 * @since: v1.0
 */
public class MessageListener implements ObserverListener {

    @Override
    public void action(Map<String, Object> message) {
        StringBuilder stringBuilder = new StringBuilder();
        message.entrySet().stream().map(e->stringBuilder.append(e.getKey()).append(":").append(e.getValue())).count();
        System.out.println("处理消息：" + stringBuilder);
    }
}
