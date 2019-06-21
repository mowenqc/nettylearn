package com.mowen.designpattern.buildmodel.factory.abstractfactory;

import com.mowen.designpattern.buildmodel.factory.model.Employee;
import com.mowen.designpattern.buildmodel.factory.model.Programmer;

/***
 * @description : 
 * 程序员工厂，生成程序员
 * @author: mowen
 * @time: 2019/6/20 19:15
 * @since: v1.0
 */
public class PragrammerFactory implements AbstractFactory {

    @Override
    public Employee create() {
        return new Programmer();
    }
}
