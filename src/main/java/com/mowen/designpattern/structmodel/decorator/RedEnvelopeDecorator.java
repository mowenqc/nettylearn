package com.mowen.designpattern.structmodel.decorator;

/***
 * @description : 装饰器模式，其实就是在源的基础上增加一些特有的功能
 *  将源包装得更为丰富，更加的符合需求，又能复用通用的功能
 * @author: mowen
 * @time: 2019/6/21 9:13
 * @since: v1.0
 */
public class RedEnvelopeDecorator implements RedEnvelope {

    private RedEnvelope redEnvelope;

    public RedEnvelopeDecorator(RedEnvelope redEnvelope){
        this.redEnvelope = redEnvelope;
    }

    @Override
    public void getMoney() {
        System.out.println("检查抢红包的资格~");
        System.out.println("检查用户的权限");
        redEnvelope.getMoney();
        System.out.println("抢红包之后发一句感谢的话");
    }

    public static void main(String[] args) {

    }
}
