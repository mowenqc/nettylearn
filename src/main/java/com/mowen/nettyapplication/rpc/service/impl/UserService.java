package com.mowen.nettyapplication.rpc.service.impl;

import com.mowen.nettyapplication.rpc.domain.User;
import com.mowen.nettyapplication.rpc.ioc.annotation.Service;
import com.mowen.nettyapplication.rpc.service.IUserService;
import java.util.ArrayList;
import java.util.List;

/***
 * desc  : com.mowen.nettyapplication.rpc.service.impl
 * author: mowen
 * create_time: 2019/6/3 8:25
 * project_name : mowen_parent
 */
@Service
public class UserService implements IUserService {

    /**
     * 模拟用户表
     */
    private static List<User> users =  new ArrayList<>();
    static {
        User user1 = new User(1, "莫问前程");
        User user2 = new User(2, "mowen");
        User user3 = new User(3, "mowenqiancheng");
        users.add(user1);
        users.add(user2);
        users.add(user3);
    }

    @Override
    public User findUserById(final int id) {
        User user = users.stream().filter(user1 -> user1.getUserId() == id).findFirst().get();
        return user;
    }

    @Override
    public User findUserByName(String name) {
        User user = users.stream().filter(user1 -> user1.getName().equals(name)).findFirst().get();
        return user;
    }

    @Override
    public List<User> listUser() {
        return users;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }
}
