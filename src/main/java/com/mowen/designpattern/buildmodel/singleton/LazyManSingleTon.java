package com.mowen.designpattern.buildmodel.singleton;

/***
 * @description : 懒汉式单例模式
 * 可以这样说：很懒，初始的时候没有创建，只有在需要的时候在创建
 * @author: mowen
 * @time: 2019/6/20 17:13
 * @since: v1.0
 */
public class LazyManSingleTon {

    private static LazyManSingleTon instance = null;

    private LazyManSingleTon(){}

    /**
     * 很常用的方法，需要的时候在创建，如果多的线程同时访问的时候，可能创建多个实例
     * @return
     */
    public static LazyManSingleTon getInstance(){
        if(instance == null){
            instance = new LazyManSingleTon();
        }
        return instance;
    }

    /**
     * 采用synchronized关键字，作为同步锁，synchronized用到方法上时，用锁定的当前类
     * 只允许在这个类的实例上需要的同步的操作只允许一个线程执行
     * @return LazyManSingleTon
     */
    public static synchronized LazyManSingleTon getSynchInstance(){
        if(instance == null){
            instance = new LazyManSingleTon();
        }
        return instance;
    }

    /**
     * 采用同步代码块的实现单例，如果instance in null, 加锁，
     * 在判断instance时候为空， 如果为空，则创建实例
     * 为什么需要判断两次了，如果在高并发的场景了， 可能在一次判断的时候，另外的一个线程已经创建了实例
     * 因为通常用单例模式对象，大而复杂的对象，创建于销毁都需要花费较大的代价才能完成
     * 这种方式要比同步方法要更为优雅，在高并发的场景下，这种创建方式是比较常用
     * @return instance
     */
    public static  LazyManSingleTon getSychBlockInstance(){
        if(instance == null){
            synchronized (instance){
                if(instance == null){
                    instance = new LazyManSingleTon();
                }
            }
        }
        return instance;
    }

    /**
     * 利用饿汉式的内部类， 解决懒汉式阴sychronized同步的性能问题
     * @return
     */
    public static LazyManSingleTon getInnerInstance(){
        return SingleTonFactory.instance;
    }

    private static class SingleTonFactory{
        private static LazyManSingleTon instance = new LazyManSingleTon();
    }

}
