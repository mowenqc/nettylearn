package com.mowen.designpattern.buildmodel.factory.abstractfactory;

import com.mowen.designpattern.buildmodel.factory.model.Employee;
import com.mowen.designpattern.buildmodel.factory.model.Programmer;
import com.mowen.designpattern.buildmodel.factory.model.Saler;

/***
 * @description :  简单工厂设计模式 ,
 * 静态工厂的实现， 工厂方法
 * 一个很重要的点：无论如何在扩展的时候需要修改工厂源代码
 * @author: mowen
 * @time: 2019/6/20 18:06
 * @since: v1.0
 */
public class AbstratoryFactory implements Factory{
    private AbstratoryFactory(){}
    /**
     * 创建销售
     * @return
     */
    @Override
    public  Employee createSaler(){
        return new Saler();
    }
    /**
     * 创建程序员
     * @return
     */
    @Override
    public  Employee createProgrammer(){
        //也是初始化一些参数
        return new Programmer();
    }
    /**
     * 通过类型创建对象，这是简单工厂的一种变形
     * @param type
     * @return
     */
    public static Employee createEmployee(int type){
        Employee employee = null;
        switch (type){
            case 1:
                employee = new Saler();
                break;
            case 2:
                employee = new Programmer();
                break;
        }
        return employee;
    }

    public static void main(String[] args) {

    }
}
