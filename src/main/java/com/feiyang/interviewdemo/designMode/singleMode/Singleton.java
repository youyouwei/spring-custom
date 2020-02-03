package com.feiyang.interviewdemo.designMode.singleMode;

/**
 * @Description: 内部静态类 只有在调用getInstance 方法时才会触发LazyHolder的初始化
 * 该方法也属于饿汉式
 *
 * @Author: jiahuiyang
 * @Date: Created in 11:06 2019/12/13
 */
public class Singleton {

    private Singleton() { }

    private static class LazyHolder {
        //jvm 类加载的最后一步是初始化，便是把直接赋值字段，以及所有静态代码块中的代码放在同一个方法中，并命名<clinit>，然后执行，并且jvm会通过加锁保护该类的<clinit>方法仅被执行一次。
        static final Singleton INSTANCE = new Singleton();
    }

    public static Singleton getInstance() {
        return LazyHolder.INSTANCE;
    }

}
