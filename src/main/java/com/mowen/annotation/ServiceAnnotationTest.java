package com.mowen.annotation;

/***
 * @desc  : 
 * @author: mowen
 * @create_time: 2019/8/29 10:25
 * @since:
 */
@Service("这个测试的方法")
public class ServiceAnnotationTest {

    public void findAnnotation(){
        System.out.println("test");
    }

    public static void main(String[] args) {
        ServiceAnnotationTest serviceAnnotationTest = new ServiceAnnotationTest();
        serviceAnnotationTest.findAnnotation();
    }
}
