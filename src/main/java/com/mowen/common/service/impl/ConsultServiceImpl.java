package com.mowen.common.service.impl;

import com.mowen.common.domain.Consult;
import com.mowen.common.service.IConsultService;

/***
 * desc  : com.mowen.dynamicproxylearn.service.impl
 * author: mowen
 * create_time: 2019/6/6 8:20
 * project_name : mowen_parent
 */
public class ConsultServiceImpl implements IConsultService {

    @Override
    public Consult findConsultById(int id) {
        Consult consult = new Consult();
        consult.setConsultId(id);
        consult.setConsultName("莫问");
        consult.setConsultNo("1000");
        return consult;
    }
}
