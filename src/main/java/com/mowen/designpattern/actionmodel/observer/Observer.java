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

    public static void main(String[] args) {
        ObserverListener listener = new MessageListener();
        IObserver observer = new Observer();
        observer.addObservered(listener);
        Map<String, Object> message = new HashMap<>();
        message.put("1", "Test");
        observer.notify(message);
    }
}
