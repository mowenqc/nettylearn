package com.mowen.designpattern.structmodel.adapter;

/***
 * @description : 
 *
 * @author: mowen
 * @time: 2019/6/20 20:29
 * @since: v1.0
 */
public class InterfaceAdapter extends AbstractAction {

    @Override
    public void drive() {
        System.out.println("只有驾车的能力");
    }

    @Override
    public void fly() {
        System.out.println("真的飞起来了~");
    }

    public static void main(String[] args) {
        InterfaceAdapter action = new InterfaceAdapter();
        action.fly();
    }
}
