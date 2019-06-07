package com.mowen.distributionlock.redisson;

import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;

/***
 * desc  : com.mowen.distributionlock.redisson
 * author: mowen
 * create_time: 2019/6/7 19:38
 * project_name : mowen_parent
 */
public class RedissonLockTest {

    /**
     * redisson已经为我们实现了分布式锁， 只需要配置使用就可以了， 是不是很方便
     * @param args
     */
    public static void main(String[] args) {
        RedissonClient client = RedissonManager.getRedissonClient();
        RLock lock = null;
        try {
            lock = client.getLock("phone");
            lock.lock();
        } catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            lock.unlock();
        }
    }
}
