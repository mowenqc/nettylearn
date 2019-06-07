package com.mowen.distributionlock.jedis;

/***
 * desc  : com.mowen.distributionlock.jedis
 * author: mowen
 * create_time: 2019/6/7 19:14
 * project_name : mowen_parent
 */
public class JedisLockTest {

    public static void main(String[] args) {
        JedisLock jedisLock = new JedisLock();
        try {
            jedisLock.lock("phone");
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            jedisLock.unLock("phone");
        }
    }

}
