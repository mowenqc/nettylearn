package com.mowen.distributionlock.zk;

import org.apache.curator.RetryPolicy;
import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.framework.recipes.locks.InterProcessMutex;
import org.apache.curator.retry.ExponentialBackoffRetry;

/***
 * desc  : com.mowen.distributionlock.zk
 * author: mowen
 * create_time: 2019/6/7 19:53
 * project_name : mowen_parent
 */
public class CuratorLockTest {

    /**
     * curator 已经为我们实现好了分布式锁， 不需要我们自己去实现， 如果自己用zkclient去实现的话， 思路是这样的
     * 1. 创建锁目录
     * 2. 申请锁是在创建节点，如果当前节点是第一个节点，则获取到锁
     * 3. 如果不是第一个节点，则监听前一个节点， 如果前一个节点发生删除操作，那么获取到锁
     * 4. 释放锁就是删除第一个节点
     * @param args
     */
    public static void main(String[] args) {
        RetryPolicy retryPolicy = new ExponentialBackoffRetry(1000, 3);
        CuratorFramework curatorFramework= CuratorFrameworkFactory.newClient("192.168.0.199:2181", retryPolicy);
        String lockPath = "/distribute-lock";
        InterProcessMutex lock = new InterProcessMutex(curatorFramework, lockPath);
        try {
            lock.acquire();
        } catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            try {
                lock.release();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }
}
