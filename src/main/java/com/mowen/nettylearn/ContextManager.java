package com.mowen.nettylearn;

import io.netty.channel.Channel;
import io.netty.channel.ChannelHandlerContext;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.apache.log4j.Logger;

/***
 * desc  : com.mowen.nettylearn
 * author: mowen
 * create_time: 2019/5/30 8:03
 * project_name : mowen_parent
 */
public class ContextManager {

    private static Logger logger = Logger.getLogger(ContextManager.class);

    private static Map<String, Channel> CONTEXT = new ConcurrentHashMap<>();

    private ContextManager(){}
    public static Channel getContext(String key){
        return CONTEXT.get(key);
    }

    /**
     * 添加context
     * @param key
     * @param context
     */
    public static void addContext(String key, Channel context){
        logger.info("addContext, key=" + key);
        if(context != null){
            CONTEXT.put(key, context);
        }
    }

    /**
     * 删除context
     * @param key
     */
    public static void removeContext(String key){
        logger.info("removeContext, key = " + key);
        CONTEXT.remove(key);
    }

}
