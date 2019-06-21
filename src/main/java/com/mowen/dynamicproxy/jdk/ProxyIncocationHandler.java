package com.mowen.dynamicproxy.jdk;

import com.mowen.dynamicproxy.DynamicProxy;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/***
 * desc  : com.mowen.dynamicproxylearn.jdk
 * author: mowen
 * create_time: 2019/6/6 8:17
 * project_name : mowen_parent
 * jdk自带
 */
public class ProxyIncocationHandler<T> implements DynamicProxy, InvocationHandler {

    private T proxyObject;
    public ProxyIncocationHandler(T proxyObject){
        this.proxyObject = proxyObject;
    }

    @Override
    public T proxy() {
        return (T) Proxy.newProxyInstance(proxyObject.getClass().getClassLoader(), proxyObject.getClass().getInterfaces(), this);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        return method.invoke(proxyObject, args);
    }
}
