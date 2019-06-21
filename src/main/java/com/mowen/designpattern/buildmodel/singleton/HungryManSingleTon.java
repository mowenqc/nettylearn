package com.mowen.designpattern.buildmodel.singleton;

/***
 * @description : 饿汉式单例模式，在内加载的时候创建实例对象
 * 这种方式叫做提前创建，不管时候需要,在使用不好单例的情况下，最好用这种方式创建
 * 普通的应用对内存的需求没有那么严格，这种方式省事又高效，不过多占用了点内存而已
 * 当然在内存紧张，访问很大的网站或应用，慎重一些
 * @author: mowen
 * @time: 2019/6/20 17:12
 * @since: v1.0
 */
public class HungryManSingleTon {

    private static HungryManSingleTon instance = new HungryManSingleTon();
    private HungryManSingleTon(){}

    public static HungryManSingleTon getInstance(){
        return instance;
    }
}
