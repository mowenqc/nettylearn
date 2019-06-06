package com.mowen.dynamicproxylearn.cglib;

import com.mowen.common.domain.Consult;
import com.mowen.common.service.IConsultService;
import com.mowen.common.service.impl.ConsultServiceImpl;

/***
 * desc  : com.mowen.dynamicproxylearn.cglib
 * author: mowen
 * create_time: 2019/6/6 13:47
 * project_name : mowen_parent
 */
public class CglibTest {

    public static void main(String[] args) {
        CglibProxy<IConsultService> cglibProxy = new CglibProxy(new ConsultServiceImpl());
        IConsultService o = cglibProxy.proxy();
        Consult consult = o.findConsultById(1);
        System.out.println(consult);
    }
}
