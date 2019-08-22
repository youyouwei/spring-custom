package com.feiyang.interviewdemo.thread.synchronizedDemo;

/**
 * @description:
 * @author: jhyang
 * @create: 2019-06-24 13:57
 **/
public class Demo {

    public static void main(String[] args) throws InterruptedException {

        SynchronizedDemo synchronizedDemo = new SynchronizedDemo();

        for (int i = 0; i < 100000; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    synchronizedDemo.addVariable();
                }
            }).start();
        }

        Thread.sleep(1000 * 5);

        System.out.println(synchronizedDemo.getVariable());


    }

    public static void autoIncrement() {

        int count = 1;

        new Thread(new Runnable() {
            @Override
            public void run() {
                //count++;   //内部类中不能使用局部变量
            }
        }).start();
    }
}
