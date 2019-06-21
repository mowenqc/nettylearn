package com.mowen.designpattern.buildmodel.factory.model;

/***
 * @description : 
 *
 * @author: mowen
 * @time: 2019/6/20 18:07
 * @since: v1.0
 */
public abstract class  Employee {

    private int id;

    private String name;

    public abstract void action();

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
