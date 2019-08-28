package com.mowen.designpattern.structmodel.proxy;

import org.apache.log4j.Logger;

/***
 * @desc  : 房东租房
 * @author: mowen
 * @create_time: 2019/8/13 20:11
 * @since:
 */
public class HouseOwner implements IRentHouse {
    private Logger logger = Logger.getLogger( getClass());

    //房东姓名
    private String name;
    public HouseOwner(String name){
        this.name = name;
    }
    @Override
    public void rentHouse() {
        logger.info(name + "房东将房间打扫干净，整理好房子");
        logger.info(name + "房东准备好钥匙");
        logger.info(name + "房东定好房价");
        logger.info(name + "房东与租客查看水电，以及要交的房租");
    }
}
