package com.mowen.designpattern.buildmodel.factory.abstractfactory;

import com.mowen.designpattern.buildmodel.factory.model.Employee;

/***
 * @description : 
 * @author: mowen
 * @create_time: 2019/7/23 20:24
 * @since: v1.0
 */
public interface Factory  {

    /**
     * 创建销售
     * @return
     */
    Employee createSaler();
    /**
     * 创建程序员
     * @return
     */
    public  Employee createProgrammer();
}
