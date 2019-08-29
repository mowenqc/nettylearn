package com.mowen.annotation;

import java.lang.annotation.*;

/***
 * @desc  : 自定义注解，几个参数详细说明
 * @Documented 能够被javaDoc识别
 * @Inherited 使用这个注解的类，子类可以继承父类的注解，也就是使用Inherited的注解的父类，如果被子类继承了，子类也拥有了这个注解
 * @Target 注解应用的作用域，几个常用的值解释一下， 我们点开ElementType, 主要有这几个属性：
 * TYPE：在类上使用
 * FIELD：类属性上使用
 * METHOD：方法上使用
 * PARAMETER：参数上使用
 * CONSTRUCTOR：构造方法上使用
 * 还有几个不常用的 * PACKAGE：包，LOCAL_VARIABLE：局部变量，ANNOTATION_TYPE：注解类型，TYPE_PARAMETER：参数类型，TYPE_USE：使用类
 * @Retention： 注解的生命周期，有RetentionPolicy注解定义：
 * SOURCE：只在源码上出现，在class文件时候忽略
 * CLASS:在源码与class文件中存在，在编译运行时jvm忽略
 * RUNTIME：存在于整个生命周期，源码、class、运行期，不会忽略
 * @author: mowen
 * @create_time: 2019/8/29 10:12
 * @since:
 */
@Documented
@Inherited
@Target(value={ElementType.TYPE, ElementType.METHOD, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface Service {
    String value();
}
