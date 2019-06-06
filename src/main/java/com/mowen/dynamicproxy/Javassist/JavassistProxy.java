package com.mowen.dynamicproxy.Javassist;

import com.mowen.dynamicproxy.DynamicProxy;
import java.lang.reflect.Method;
import javassist.util.proxy.MethodHandler;
import javassist.util.proxy.ProxyFactory;
import org.apache.log4j.Logger;

/***
 * desc  : com.mowen.dynamicproxylearn.Javassist
 * author: mowen
 * create_time: 2019/6/6 14:14
 * project_name : mowen_parent
 */
public class JavassistProxy<T> implements DynamicProxy<T>, MethodHandler {

    private Logger logger = Logger.getLogger(getClass());
    ProxyFactory proxyFactory = new ProxyFactory();

    private T proxyObject;
    public JavassistProxy(T t){
        this.proxyObject  = t;
        proxyFactory.setSuperclass(proxyObject.getClass());
        proxyFactory.setHandler(this);
    }

    @Override
    public T proxy() {
        try {
            return (T)proxyFactory.createClass().newInstance();
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
        }
        return null;
    }

    @Override
    public Object invoke(Object o, Method method, Method method1, Object[] objects)
        throws Throwable {
        logger.info("object = " + o.getClass().getName());
        logger.info("method = " + method.getName());
        logger.info("method1 = " + method1.getName());
        Object invoke = method1.invoke(o, objects);
        return invoke;
    }
}
