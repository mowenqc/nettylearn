package com.mowen.distributionlock.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.concurrent.locks.LockSupport;
import org.apache.log4j.Logger;

/***
 * desc  : com.mowen.distributionlock.db
 * author: mowen
 * create_time: 2019/6/6 17:23
 * project_name : mowen_parent
 */
public class DbLock {

    private Logger logger = Logger.getLogger(getClass());
    /**
     * 首先我们需要在数据库中建一个表 CREATE TABLE `distribution_lock` ( lock_name varchar(100) COLLATE utf8_bin
     * NOT NULL, `description` varchar(200) COLLATE utf8_bin NOT NULL, PRIMARY KEY (`lock_name`) )
     * ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
     */

    public boolean lock(String name) {
        Connection connection = null;
        if (name == "" || name == null) {
            name = "common-lock";
        }
        logger.info("开始获取锁：" + name);
        try {
            connection = ConnectionFactory.borrowConnection();
            String sql = "insert into distribution_lock(lock_name, description) values(?,?)";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, name);
            statement.setString(2, "简单的描述，可要可不要");
            statement.execute();
            System.out.println("未插入成功，暂停1秒");
            return true;

        } catch (Exception e) {
            e.printStackTrace();
            LockSupport.parkNanos(1000000000);
            lock(name);
        } finally {
            if (connection != null) {
                ConnectionFactory.returnConnection(connection);
            }
            logger.info("锁为获取成功，休眠1秒");
        }
        return false;
    }

    public boolean unLock(String name){
        Connection connection = null;
        if (name == "" || name == null) {
            name = "common-lock";
        }
        try {
            connection = ConnectionFactory.borrowConnection();
            String sql = "delete from distribution_lock where lock_name = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, name);
            return true;
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            return false;
        }
    }
}
