package com.mowen.designpattern.structmodel.proxy;

/***
 * @description : 动态代理的参照 com.mowen.dynamicproxy
 *  代理审核的中介， 真正执行的是government
 *  这就是代理模式，举个例子， 我们去买房， 自己一般找不到房东
 *  而是找个中介，我们在中介那儿购买，中介代为和房东、银行对接
 * @author: mowen
 * @time: 2019/6/21 14:10
 * @since: v1.0
 */
public class MediumProxy implements CheckDepartment{

    private CheckDepartment checkDepartment;

    public MediumProxy(){
        checkDepartment = new Government();
    }

    @Override
    public void checkEstate() {
        System.out.println("代理之前做点啥");
        checkDepartment.checkEstate();
        System.out.println("执行完了有插入做点啥");
    }
}
