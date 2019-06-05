package com.mowen.connectionpool.pool2;

import java.sql.Connection;
import org.apache.commons.pool2.impl.GenericObjectPool;
import org.apache.commons.pool2.impl.GenericObjectPoolConfig;

/***
 * desc  : com.mowen.connectionpool.pool2
 * author: mowen
 * create_time: 2019/6/5 10:08
 * project_name : mowen_parent
 */
public class CommonConnectionPool extends GenericObjectPool<Connection> {

    /**
     * 采用默认的配置
     */
    public CommonConnectionPool() {
        super(new ObjectFactory());
    }

    /**
     * 通常自己的连接池中，需要传入 GenericObjectPoolConfig
     * @param config
     */
    public CommonConnectionPool(GenericObjectPoolConfig config){
        super(new ObjectFactory(), config);
    }
}
