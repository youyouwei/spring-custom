package com.feiyang.interviewdemo.designMode.singleMode;

/**
 * @Description: 双重验证
 * @Author: jiahuiyang
 * @Date: Created in 11:12 2019/12/13
 */
public class DoubleLockSingleton {

    private DoubleLockSingleton(){}

    /**
     * singleton 内存可见性
     */
    private volatile static DoubleLockSingleton singleton;


    public static DoubleLockSingleton getInstance() {

        //双重检验
        if (singleton == null) {

            synchronized (DoubleLockSingleton.class) {
                //双重校验的目的是在当前线程获取锁等待过程中其他线程已经完成初始化并且释放锁，所以避免造成重复构建 主要是Java内存模型的synchronized的happen-before原则
                if (singleton == null) {
                    singleton = new DoubleLockSingleton();
                }
            }

        }

        return singleton;

    }





}
