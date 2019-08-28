package com.mowen.lamda.expression;

/***
 * @desc  : 
 * @author: mowen
 * @create_time: 2019/8/28 9:26
 * @since:
 */
@FunctionalInterface
public interface IUserNameService {

    String findName(int id);
}
