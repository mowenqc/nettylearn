package com.mowen.designpattern.structmodel.bridge;

/***
 * @description : 
 * 桥接模式就是把事物和其具体实现分开，使他们可以各自独立的变化。桥接的用意是：将抽象化与实现化解耦，使得二者可以独立变化，像我们常用的JDBC桥DriverManager一样，
 * JDBC进行连接数据库的时候，在各个数据库之间进行切换，基本不需要动太多的代码，甚至丝毫不用动，原因就是JDBC提供统一接口，每个数据库提供各自的实现
 * @author: mowen
 * @time: 2019/6/21 15:47
 * @since: v1.0
 */
public class PragrammerBridge extends Bridge {

    @Override
    public void doString() {
        super.doString();
    }

    public static void main(String[] args) {
        Bridge bridge = new PragrammerBridge();
        bridge.setWorker(new Pragrammer());
        bridge.doString();
    }
}
