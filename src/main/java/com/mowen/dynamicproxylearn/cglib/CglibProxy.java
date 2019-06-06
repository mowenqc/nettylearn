package com.mowen.dynamicproxylearn.cglib;

import com.mowen.dynamicproxylearn.DynamicProxy;
import java.lang.reflect.Method;
import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;
import org.apache.log4j.Logger;

/***
 * desc  : com.mowen.dynamicproxylearn.cglib
 * author: mowen
 * create_time: 2019/6/6 13:44
 * project_name : mowen_parent
 */
public class CglibProxy<T>  implements DynamicProxy<T>, MethodInterceptor {

    private Logger logger = Logger.getLogger(getClass());

    private T t;
    public CglibProxy(T t){
        this.t = t;
    }
    @Override
    public T proxy() {
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(t.getClass());
        enhancer.setCallback(this);
        T t = (T) enhancer.create();
        return t;
    }

    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy)
        throws Throwable {
        logger.info("执行：" + o.getClass().getName() + "的method：" + method.getName());
        Object invokeSuper = methodProxy.invokeSuper(o, objects);
        logger.info("执行完成~准备返回值");
        return invokeSuper;
    }
}
