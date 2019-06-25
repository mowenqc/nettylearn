package com.mowen.designpattern.actionmodel.strategy;

/***
 * @description : 
 *
 * @author: mowen
 * @time: 2019/6/25 11:27
 * @since: v1.0
 */
public class DivideStategy extends AbstractStrategy {

    @Override
    public int operate(int a, int b) {
        if(b == 0){
            return Integer.MAX_VALUE;
        }
        return a/b;
    }
}
