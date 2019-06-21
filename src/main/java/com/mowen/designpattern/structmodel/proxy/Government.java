package com.mowen.designpattern.structmodel.proxy;

/***
 * @description : 
 * 真正执行的功能
 * @author: mowen
 * @time: 2019/6/21 14:17
 * @since: v1.0
 */
public class Government implements CheckDepartment {

    @Override
    public void checkEstate() {
        System.out.println("政府审核房产~");
    }
}
