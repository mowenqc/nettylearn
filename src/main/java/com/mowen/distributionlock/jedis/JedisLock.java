package com.mowen.distributionlock.jedis;

import java.util.concurrent.locks.LockSupport;

/***
 * desc  : com.mowen.distributionlock.jedis
 * author: mowen
 * create_time: 2019/6/7 19:09
 * project_name : mowen_parent
 */
public class JedisLock {
    private JedisTemplate jedisTemplate;
    public JedisLock(){
        jedisTemplate = new JedisTemplate();
    }

    public boolean lock(String lockName){
        for (;;){
            long nx = jedisTemplate.setNx(lockName, lockName);
            if(nx > 0){
                System.out.println("获取到锁，返回成功");
                return true;
            }
            //如果未获取到锁， 则等待0.5秒
            System.out.println("lockName = " + lockName + "未获取到锁，等待0.5");
            LockSupport.parkUntil(1000);
        }
    }

    public void unLock(String lockName){
        jedisTemplate.delKey(lockName);
    }
}
