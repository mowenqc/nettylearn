package com.mowen.connectionpool.customize;

import java.sql.Connection;

/***
 * desc  : com.mowen.connectionpool.customize
 * author: mowen
 * create_time: 2019/6/5 17:29
 * project_name : mowen_parent
 */
public class CustomizeObjectPool<Connection> extends CustomizeAbstractObjectPool<Connection> {
    public CustomizeObjectPool() {
        super(new CustomizeObjectFactory());
    }
}
