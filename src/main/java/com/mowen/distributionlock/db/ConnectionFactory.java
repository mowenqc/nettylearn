package com.mowen.distributionlock.db;

import com.mowen.connectionpool.customize.CustomizeObjectPool;
import java.sql.Connection;

/***
 * desc  : com.mowen.distributionlock.db
 * author: mowen
 * create_time: 2019/6/6 17:37
 * project_name : mowen_parent
 */
public class ConnectionFactory {
    public static CustomizeObjectPool<Connection> commonConnectionPool = new CustomizeObjectPool();
    private ConnectionFactory(){}

    public static Connection borrowConnection(){
        return commonConnectionPool.borrowObject();
    }

    public static void returnConnection(Connection connection){
        commonConnectionPool.returnObject(connection);
    }

}
