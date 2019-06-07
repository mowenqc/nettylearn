package com.mowen.distributionlock.redisson;

import org.redisson.Redisson;
import org.redisson.api.RedissonClient;
import org.redisson.config.Config;

/***
 * desc  : com.mowen.distributionlock.redission
 * author: mowen
 * create_time: 2019/6/7 19:30
 * project_name : mowen_parent
 */
public class RedissonManager {

    private static RedissonClient redissonClient;
    static {
        Config config = new Config();
        config.useClusterServers() //这是用的集群server
            .setScanInterval(2000) //设置集群状态扫描时间
            .setMasterConnectionPoolSize(10000) //设置连接数
            .setSlaveConnectionPoolSize(10000)
            .addNodeAddress("192.168.0.86:6379","192.168.0.86:6380");
        redissonClient = Redisson.create(config);
    }

    public static RedissonClient getRedissonClient(){
        return redissonClient;
    }
}
