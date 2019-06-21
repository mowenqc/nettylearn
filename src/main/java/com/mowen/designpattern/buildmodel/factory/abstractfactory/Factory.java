package com.mowen.designpattern.buildmodel.factory.abstractfactory;

import com.mowen.designpattern.buildmodel.factory.model.Employee;

/***
 * @description : 
 *  用到装饰模式的工厂，更为好用
 * @author: mowen
 * @time: 2019/6/20 19:18
 * @since: v1.0
 */
public class Factory implements AbstractFactory {

    private AbstractFactory factory;

    public Factory(AbstractFactory factory){
        this.factory = factory;
    }
    @Override
    public Employee create() {
        System.out.println("这是一个装饰模式的factory，可用性更强");
        return factory.create();
    }
}
