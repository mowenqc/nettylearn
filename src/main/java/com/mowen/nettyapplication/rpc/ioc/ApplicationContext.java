package com.mowen.nettyapplication.rpc.ioc;

import com.mowen.nettyapplication.rpc.ioc.annotation.Service;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import org.apache.log4j.Logger;
import org.jboss.errai.reflections.Reflections;

/***
 * desc  : com.mowen.nettyapplication.rpc.ioc
 * author: mowen
 * create_time: 2019/6/2 15:48
 * project_name : mowen_parent
 */
public class ApplicationContext {

    private static Logger logger = Logger.getLogger(ApplicationContext.class);
    public static Map<String, Object> CONTEXT = new HashMap<>();

    /**
     * 初始化prefix的前缀包下的类
     * @param prefix
     */
    public static void init(String prefix){
        //初始换容器
        try {
            Reflections reflections = new Reflections(prefix, null);
            Set<Class<?>> classSet = reflections.getTypesAnnotatedWith(Service.class);
            if(classSet == null || classSet.size() == 0){
                return;
            }
            for (Class<?> aClass : classSet) {
                String name = aClass.getSimpleName();
                name = name.substring(0,1).toLowerCase() + name.substring(1);
                CONTEXT.put(name, aClass.newInstance());
            }
        } catch (Exception e) {
           logger.error(e.getMessage(), e);
        }

    }

}
