package com.mowen.annotation;

import java.lang.annotation.*;

/***
 * @desc  : 定义一个牛逼的注解， 我们可以在讲解反射的时候使用
 * @author: mowen
 * @create_time: 2019/8/29 10:44
 * @since: v1.0
 */
@Documented
@Inherited
@Target(value = {ElementType.FIELD, ElementType.TYPE,ElementType.METHOD, ElementType.CONSTRUCTOR})
@Retention(RetentionPolicy.RUNTIME)
public @interface Niubility {

    /**
     * 牛逼的名字
     * @return
     */
    String name();
}
