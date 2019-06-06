package com.mowen.common.service;

import com.mowen.common.domain.User;
import java.util.List;

/***
 * desc  : com.mowen.nettyapplication.rpc.service
 * author: mowen
 * create_time: 2019/6/3 8:21
 * project_name : mowen_parent
 */
public interface IUserService {

    /**
     * 获取用户信息
     * @param id 用户id
     * @return
     */
    User findUserById(int id);

    /**
     * 获取用户信息
     * @param name 用户姓名
     * @return
     */
    User findUserByName(String name);

    /**
     * 获取所有的用户，当然实际中应该是分页获取
     * @return
     */
    List<User> listUser();
}
