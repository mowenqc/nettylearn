package com.mowen.dynamicproxylearn.Javassist;

import com.mowen.common.domain.Consult;
import com.mowen.common.service.IConsultService;
import com.mowen.common.service.impl.ConsultServiceImpl;

/***
 * desc  : com.mowen.dynamicproxylearn.Javassist
 * author: mowen
 * create_time: 2019/6/6 14:25
 * project_name : mowen_parent
 */
public class JavassistProxyTest {

    public static void main(String[] args) {
        IConsultService consultService = new JavassistProxy<IConsultService>(new ConsultServiceImpl()).proxy();
        Consult consult = consultService.findConsultById(3);
        System.out.println(consult);
    }
}
