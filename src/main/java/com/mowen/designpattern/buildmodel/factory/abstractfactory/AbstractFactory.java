package com.mowen.designpattern.buildmodel.factory.abstractfactory;

import com.mowen.designpattern.buildmodel.factory.model.Employee;

/***
 * @description : 
 * 抽象工厂的接口
 * @author: mowen
 * @time: 2019/6/20 19:08
 * @since: v1.0
 */
public interface AbstractFactory {
    /**
     * 创建对象
     * @return
     */
    Employee create();
}
