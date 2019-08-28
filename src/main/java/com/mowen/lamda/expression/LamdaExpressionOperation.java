package com.mowen.lamda.expression;

import java.util.function.BinaryOperator;

import static com.alibaba.druid.sql.visitor.SQLEvalVisitorUtils.add;

/***
 * @desc  : 
 * @author: mowen
 * @create_time: 2019/8/27 19:25
 * @since:
 */
public class LamdaExpressionOperation {


    public void function(){
        BinaryOperator<Long> add = (Long x,Long y) -> x + y;
        Long add1 =  (long)add(1L, 2L);
        System.out.println(add1);

        Runnable runnable = ()-> System.out.println("test");
        Thread thread = new Thread(runnable);
        thread.start();

    }

    public static void main(String[] args) {
        new LamdaExpressionOperation().function();
    }

}
