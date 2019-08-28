package com.mowen.designpattern.actionmodel.observer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/***
 * @description : 
 * 观察者， 用一个list保存被观察者，通知就是将注册的list中的对象都执行一遍
 * @author: mowen
 * @time: 2019/6/25 14:52
 * @since: v1.0
 */
public class Observer implements IObserver {
    int state;
    List<ObserverListener> observerListeners = new ArrayList<>();
    @Override
    public void addObservered(ObserverListener listener) {
        observerListeners.add(listener);
    }

    @Override
    public void unRegister(ObserverListener listener) {
        observerListeners.remove(listener);
    }

    @Override
    public void notify(Map<String, Object> message) {
        observerListeners.forEach(observerListeners -> observerListeners.action(message));
    }

    @Override
    public void stateChange(int state) {
        this.state = state;
        Map<String, Object> message = new HashMap<>();
        message.put("" + state, "状态被改变了，执行通知所有的被观察者执行各自的操作");
        notify(message);
    }

    public static void main(String[] args) {
        ObserverListener listener = new MessageListener();
        IObserver observer = new Observer();
        observer.addObservered(listener);
        observer.stateChange(2);
    }
}
