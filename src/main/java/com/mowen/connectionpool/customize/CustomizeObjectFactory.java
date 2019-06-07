package com.mowen.connectionpool.customize;

import com.mowen.connectionpool.druid.Config;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/***
 * desc  : com.mowen.connectionpool.customize
 * author: mowen
 * create_time: 2019/6/5 11:01
 * project_name : mowen_parent
 */
public class CustomizeObjectFactory implements AbstractObjectFactory<Connection> {
    private String driver;

    private String url;

    private String userName;

    private String password;


    public CustomizeObjectFactory(){
        System.setProperty("driver", Config.DRIVER);
        System.setProperty("jdbc-url", Config.URL);
        System.setProperty("username", Config.USER_NAME);
        System.setProperty("password", Config.PASSWORD);
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
    public Connection createObject() {
        try {
            Connection connection = DriverManager.getConnection(url, userName, password);
            return connection;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
}
