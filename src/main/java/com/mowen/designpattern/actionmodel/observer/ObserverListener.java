package com.mowen.designpattern.actionmodel.observer;

import java.util.Map;

/***
 * @description : 
 *
 * @author: mowen
 * @time: 2019/6/25 14:47
 * @since: v1.0
 */
public interface ObserverListener {

    void action(Map<String, Object> message);
}
