package com.mowen.connectionpool.druid;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.pool.DruidPooledConnection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/***
 * desc  : com.mowen.connectionpool.druid
 * author: mowen
 * create_time: 2019/6/5 7:46
 * project_name : mowen_parent
 */
public class DruidTest {

    public static void main(String[] args) {
        /**
         * 获取druid连接
         */
        DruidDataSource dataSource = getDruidDataSource();
        DruidPooledConnection connection;
        try {
            connection = dataSource.getConnection();
            String sql = "select * from m_account";
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();
            ResultSetMetaData metaData = resultSet.getMetaData();
            int columnCount = metaData.getColumnCount();
            List<Map<String, Object>> list = new ArrayList<>();
            /**
             * 如果在此做个ORM，类似于mybatis， 也是很简单的，当然麻烦，给个Map搞定， 真实环境肯定不能这样搞
             */
            while (resultSet.next()){
                Map<String, Object> column = new HashMap<>();
                for(int i = 1; i <= columnCount; i++){
                    column.put(metaData.getColumnLabel(i), resultSet.getObject(i));
                }
                list.add(column);
            }
            System.out.println(list);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static DruidDataSource getDruidDataSource() {
        /**
         * 初始换数据源， 很简单的几个配置，制定驱动，数据库，连接池的大小，注意我这儿用的是mysql8在驱动与url都有所有变化
         */
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setDriverClassName(Config.DRIVER);
        dataSource.setInitialSize(Config.INITIAL_SIZE);
        dataSource.setMaxActive(Config.MAX_ACTIVE);
        dataSource.setUrl(Config.URL);
        dataSource.setUsername(Config.USER_NAME);
        dataSource.setPassword(Config.PASSWORD);
        return dataSource;
    }

}
