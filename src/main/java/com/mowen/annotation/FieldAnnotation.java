package com.mowen.annotation;

import java.lang.annotation.*;

/***
 * @desc  : 
 * @author: mowen
 * @create_time: 2019/8/29 11:29
 * @since:
 */
@Documented
@Inherited
@Target(value = {ElementType.FIELD, ElementType.TYPE,ElementType.METHOD, ElementType.CONSTRUCTOR})
@Retention(RetentionPolicy.RUNTIME)
public @interface FieldAnnotation {
}
