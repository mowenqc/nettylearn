package com.mowen.designpattern.structmodel.proxy;

/***
 * @desc  : 租房客向中介租房
 * @author: mowen
 * @create_time: 2019/8/14 8:10
 * @since:
 */
public class CustomerRent {

    public static void main(String[] args) {
        HouseAgent houseAgent = new HouseAgent("李阿姨");
        //顾客向中介租房， 很形象的过程，你向中介租李阿姨家的房子
        houseAgent.rentHouse();
    }
}
