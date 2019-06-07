package com.mowen.distributionlock.db;

/***
 * desc  : com.mowen.distributionlock.db
 * author: mowen
 * create_time: 2019/6/7 18:30
 * project_name : mowen_parent
 */
public class DbLockTest {

    public static void main(String[] args) {
        DbLock dbLock = new DbLock();
        try {
            dbLock.lock("phone");
            Thread.sleep(10000);
        } catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            dbLock.unLock("phone");
        }
    }
}
