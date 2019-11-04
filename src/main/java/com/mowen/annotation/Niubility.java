package com.mowen.annotation;

import java.lang.annotation.*;

/***
 * @desc  : 定义一个牛逼的注解， 我们可以在讲解反射的时候使用
 * 使用的时候，如果不强制使用注解的属性，方法定义为空，要么加上一个默认值
 * 如果在此，我们将默认的value（）的默认值设置成"",
 * 当然也可以定义其他值， 比如这儿的name()，同时设置好默认值
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
    String value() default "";

    String name() default "牛逼的人";
}
