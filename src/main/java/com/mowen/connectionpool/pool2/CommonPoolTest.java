package com.mowen.connectionpool.pool2;

import com.mowen.connectionpool.druid.Config;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/***
 * desc  : com.mowen.connectionpool.pool2
 * author: mowen
 * create_time: 2019/6/5 10:13
 * project_name : mowen_parent
 */
public class CommonPoolTest {

    public static void main(String[] args) {

        System.setProperty("driver", Config.DRIVER);
        System.setProperty("jdbc-url", Config.URL);
        System.setProperty("username", Config.USER_NAME);
        System.setProperty("password", Config.PASSWORD);

        CommonConnectionPool commonConnectionPool = new CommonConnectionPool();
        Connection connection = null;
        try {
            connection = commonConnectionPool.borrowObject();
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
        } catch (Exception e) {
           e.printStackTrace();
        }
        finally {
            if(connection != null){
                commonConnectionPool.returnObject(connection);
            }
        }
    }

}
