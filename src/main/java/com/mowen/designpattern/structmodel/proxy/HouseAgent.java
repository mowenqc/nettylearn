package com.mowen.designpattern.structmodel.proxy;

import org.apache.log4j.Logger;

/***
 * @desc  : 租房中介代理类，
 * @author: mowen
 * @create_time: 2019/8/13 20:14
 * @since:
 */
public class HouseAgent implements IRentHouse {
    private Logger logger = Logger.getLogger( getClass());

    private HouseOwner houseOwner;

    public HouseAgent(String ownerName){
        logger.info("中介从房东那儿拿来钥匙");
        logger.info("中介从房东欲出租的价格以及相应的要求，清点房租房间的家具");
        houseOwner = new HouseOwner(ownerName);
    }

    @Override
    public void rentHouse() {
        boolean intend = true;//是否有意愿租房
        logger.info("中介带你去看房");
        logger.info("中介给你讲解房间的亮点");
        logger.info("中介给你报价");
        if(intend){
            logger.info("你和中介签订租房合同");
            logger.info("你交中介费给中介");
            houseOwner.rentHouse();//真正的房东这时才出现
            logger.info("你拿到钥匙，搬家，这儿就属于你啦");
        }
        else {
            logger.info("中介带你去看其他房源");
            logger.info("......");
        }
    }
}
