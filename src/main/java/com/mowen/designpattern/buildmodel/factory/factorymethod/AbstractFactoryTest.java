package com.mowen.designpattern.buildmodel.factory.factorymethod;

import com.mowen.designpattern.buildmodel.factory.model.Employee;

/***
 * @description : 
 *
 * @author: mowen
 * @time: 2019/6/20 19:16
 * @since: v1.0
 */
public class AbstractFactoryTest {

    public static void main(String[] args) {

        saleAction();

        pragrammerAction();

        sale1Action();
    }

    private static void saleAction() {
        AbstractFactory factory = new SalerFactory();
        Employee employee = factory.create();
        employee.action();
    }

    private static void pragrammerAction() {
        AbstractFactory factory = new PragrammerFactory();
        Employee employee = factory.create();
        employee.action();
    }

    private static void sale1Action(){
        Factory factory = new Factory(new SalerFactory());
        Employee employee = factory.create();
        employee.action();
    }
}
