package com.mowen.common.service;

import com.mowen.common.domain.Consult;

/***
 * desc  : com.mowen.dynamicproxylearn.service
 * author: mowen
 * create_time: 2019/6/6 8:20
 * project_name : mowen_parent
 */
public interface IConsultService {

    Consult findConsultById(int id);

}
