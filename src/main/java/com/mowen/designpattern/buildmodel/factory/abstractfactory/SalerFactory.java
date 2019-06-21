package com.mowen.designpattern.buildmodel.factory.abstractfactory;

import com.mowen.designpattern.buildmodel.factory.model.Employee;
import com.mowen.designpattern.buildmodel.factory.model.Saler;

/***
 * @description : 
 * 销售工厂，生产销售
 * @author: mowen
 * @time: 2019/6/20 19:14
 * @since: v1.0
 */
public class SalerFactory implements AbstractFactory {

    @Override
    public Employee create() {
        return new Saler();
    }
}
