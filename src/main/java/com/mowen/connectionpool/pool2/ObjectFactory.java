package com.mowen.connectionpool.pool2;

import com.mowen.connectionpool.druid.Config;
import java.sql.Connection;
import java.sql.DriverManager;
import org.apache.commons.pool2.BasePooledObjectFactory;
import org.apache.commons.pool2.PooledObject;
import org.apache.commons.pool2.impl.DefaultPooledObject;

/***
 * desc  : com.mowen.connectionpool.pool2
 * author: mowen
 * create_time: 2019/6/5 9:37
 * project_name : mowen_parent
 */
public class ObjectFactory extends BasePooledObjectFactory<Connection> {

    private String driver;

    private String url;

    private String userName;

    private String password;

    public ObjectFactory(){
        init();
    }

    private void init(){
        driver = System.getProperty("driver");
        url = System.getProperty("jdbc-url");
        userName = System.getProperty("username");
        password = System.getProperty("password");
        try {
            Class.forName(driver);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }



    @Override
    public Connection create() throws Exception {
        Connection connection = DriverManager.getConnection(url, userName, password);
        return connection;
    }

    @Override
    public PooledObject<Connection> wrap(Connection connection) {
        return new DefaultPooledObject<Connection>(connection);
    }
}
