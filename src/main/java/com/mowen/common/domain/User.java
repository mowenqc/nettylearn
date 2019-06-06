package com.mowen.common.domain;

import java.io.Serializable;
import java.util.Date;

/***
 * desc  : com.mowen.nettyapplication.rpc.domain， 简单用户类
 * author: mowen
 * create_time: 2019/6/3 8:22
 * project_name : mowen_parent
 */
public class User  implements Serializable {

    private int userId;

    private String name;

    private String email;

    private Date birthday;

    public User(){

    }
    public User(int userId, String name, String email, Date birthday){
        this.userId = userId;
        this.name = name;
        this.email = email;
        this.birthday = birthday;
    }
    public User(int userId, String name){
        this(userId, name, null, null);
    }
    public User(int userId, String name, String email){
        this(userId, name, email, null);
    }
    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    @Override
    public String toString() {
        return "User{" +
            "userId=" + userId +
            ", name='" + name + '\'' +
            ", email='" + email + '\'' +
            ", birthday=" + birthday +
            '}';
    }
}
