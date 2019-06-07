package com.mowen.distributionlock.jedis;

import org.apache.commons.pool2.impl.GenericObjectPoolConfig;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

/***
 * desc  : com.mowen.distributionlock.jedis
 * author: mowen
 * create_time: 2019/6/7 18:53
 * project_name : mowen_parent
 */
public class CustomizeJedisPool extends JedisPool {

    public CustomizeJedisPool(){
        super(new GenericObjectPoolConfig(),"192.168.0.86", 6379, 5000, "ytxredis");
    }

    public Jedis borrowResouce(){
        return getResource();
    }

    public void returnBorrowResource(Jedis jedis){
        if(jedis == null){
            return;
        }
        returnBrokenResource(jedis);
    }
}
