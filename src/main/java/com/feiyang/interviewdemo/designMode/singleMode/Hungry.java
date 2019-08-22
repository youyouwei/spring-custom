package com.feiyang.interviewdemo.designMode.singleMode;

/**
 * @description: 单例模式 饿汉式 它是在类加载的时候立即初始化，并且創建单例对象
 * 优点：没有加任何的锁，执行效率比较高
 * 在用户
 * @author: jhyang
 * @create: 2019-06-28 20:56
 **/
public class Hungry {
    private Hungry() {
    }

    private static final Hungry hungry = new Hungry();

    public static Hungry getInstance() {
        return hungry;
    }
}
