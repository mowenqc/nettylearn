package com.mowen.connectionpool.druid;

/***
 * desc  : com.mowen.connectionpool.druid
 * author: mowen
 * create_time: 2019/6/5 7:43
 * project_name : mowen_parent
 */
public class Config {

    public static final String DRIVER = "com.mysql.cj.jdbc.Driver";
    public static final String URL = "jdbc:mysql://127.0.0.1/material?useUnicode=true&characterEncoding=UTF8&zeroDateTimeBehavior=convertToNull&autoReconnect=true&idleConnectionTestPeriod=120&preferredTestQuery=select now()&serverTimezone=UTC";
    public static final String USER_NAME = "root";
    public static final String PASSWORD = "root";
    public static final int MAX_ACTIVE = 20;
    public static final int INITIAL_SIZE = 5;

}
