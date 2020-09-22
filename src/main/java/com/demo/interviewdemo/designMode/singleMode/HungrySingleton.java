package com.demo.interviewdemo.designMode.singleMode;

/**
 * @description: 单例模式 饿汉式 它是在类加载的时候立即初始化，并且創建单例对象
 * 优点：没有加任何的锁，执行效率比较高
 * 缺点：在类加载后就初始化 某种程度上占用内存
 *
 * @author: jhyang
 * @create: 2019-06-28 20:56
 **/
public class HungrySingleton {
    private HungrySingleton() {
    }

    private static final HungrySingleton hungry = new HungrySingleton();

    public static HungrySingleton getInstance() {
        return hungry;
    }
}
