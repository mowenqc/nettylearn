package com.mowen.distributionlock.jedis;

import redis.clients.jedis.Jedis;

/***
 * desc  : com.mowen.distributionlock.jedis
 * author: mowen
 * create_time: 2019/6/7 18:40
 * project_name : mowen_parent
 */
public class JedisTemplate {
    private CustomizeJedisPool jedisPool;

    public JedisTemplate(){
        jedisPool = new CustomizeJedisPool();
    }

    public String get(String key){
        Jedis jedis = null;
        try {
            jedis = jedisPool.borrowResouce();
            String s = jedis.get(key);
            return s;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            jedisPool.returnBorrowResource(jedis);
        }
        return null;
    }

    /**
     * 如果结果为1 设置成功， 如果结果为0设置失败
     * @param key key
     * @param value
     * @return
     */
    public long setNx(String key, String value){
        Jedis jedis = null;
        try {
            jedis = jedisPool.borrowResouce();
            return jedis.setnx(key, value);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            jedisPool.returnBorrowResource(jedis);
        }
        return 0;
    }

    public void delKey(String key){
        Jedis jedis = null;
        try {
            jedis = jedisPool.borrowResouce();
            jedis.del(key);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            jedisPool.returnBorrowResource(jedis);
        }
    }


}
