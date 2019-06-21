package com.mowen.designpattern.structmodel.adapter;

/***
 * @description : 
 *
 * @author: mowen
 * @time: 2019/6/20 20:24
 * @since: v1.0
 */
public class ObjectAdapter implements Action {

    private People people;

    public ObjectAdapter(People people){
        this.people = people;
    }
    @Override
    public void drive() {
        people.drive();
    }

    @Override
    public void walk() {
        System.out.println("具有了行走了能力");
    }

    @Override
    public void run() {
        System.out.println("具有跑的能力");
    }

    public static void main(String[] args) {
        Action action = new ObjectAdapter(new People());
        action.walk();
        action.run();
        action.drive();
    }
}
