package com.mowen.test;

import com.mowen.nettylearn.common.util.DateUtil;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import org.junit.Test;

/***
 * desc  :
 * author:mayn
 * create_time: 2018/12/15 15:04
 * project_name : mowen_parent
 */
public class CommonTest {

    @Test
    public void testAdd(){

        System.out.println(4|0xfff);
        System.out.println(5|0xfff);
        System.out.println(6&0xfff);
        System.out.println(7&0xfff);
    }

    @Test
    public void testDateOrder(){
        List<Date> list = new ArrayList<>();
        list.add(DateUtil.stringToDate("2018-05-09 10:20:10", DateUtil.DATETIME_FORMAT));
        list.add(DateUtil.stringToDate("2019-05-09 10:20:10", DateUtil.DATETIME_FORMAT));
        Collections.sort(list, (o1,o2)-> o2.compareTo(o1));
        System.out.println(list);
    }
}
