package com.mowen.lamda.expression;

/***
 * @desc  : 
 * @author: mowen
 * @create_time: 2019/8/28 9:28
 * @since:
 */
public class UserNameService {

    IUserNameService userNameService;

    public UserNameService(IUserNameService userNameService){
        this.userNameService = userNameService;
    }
    public String findUserName(int x){
        return userNameService.findName(x);
    }


    public static void main(String[] args) {
        String name = new UserNameService((x)-> "ID_" + x).findUserName(3);
        System.out.println(name);
    }
}
