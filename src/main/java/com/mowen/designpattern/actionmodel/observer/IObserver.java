package com.mowen.designpattern.actionmodel.observer;

import java.util.Map;

/***
 * @description : 
 *
 * @author: mowen
 * @time: 2019/6/25 14:45
 * @since: v1.0
 */
public interface IObserver {

    /**
     * 注册监听
     * @param listener
     */
    void addObservered(ObserverListener listener);

    /**
     * 取消注册
     * @param listener
     */
    void unRegister(ObserverListener listener);

    /**
     * 监听状态改变
     * @param state
     */
    void stateChange(int state);
    /**
     * 消息
     * @param message
     */
    void notify(Map<String, Object> message);
}
