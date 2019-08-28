package com.mowen.designpattern.buildmodel.factory.simplefactory;

import com.mowen.designpattern.buildmodel.factory.model.Employee;
import com.mowen.designpattern.buildmodel.factory.model.Programmer;
import com.mowen.designpattern.buildmodel.factory.model.Saler;

/***
 * @desc  : 简单工厂类，也叫静态工厂，能够根据提供的类型创建出同类型的产品
 * @author: mowen
 * @create_time: 2019/8/12 10:21
 * @since:
 */
public class SimpleFactory {
    /**
     * 通过参数，控制创建的具体的实例对象，返回的是抽象的类
     * @param type
     * @return
     */
    public static Employee createEmployee(String type){
        if(type.equals("programmer")){
            return new Programmer();
        }
        else if(type.equals("saler")){
            return new Saler();
        }
        return null;
    }
}
