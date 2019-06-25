package com.mowen.designpattern.actionmodel.strategy;

/***
 * @description : 
 *
 * @author: mowen
 * @time: 2019/6/25 11:25
 * @since: v1.0
 */
public class MaxStrategy extends AbstractStrategy {

    @Override
    public int operate(int a, int b) {
        return a > b ? a: b;
    }
}
