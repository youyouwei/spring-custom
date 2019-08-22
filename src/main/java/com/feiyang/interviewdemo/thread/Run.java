package com.feiyang.interviewdemo.thread;

/**
 * @description:
 * @author: jhyang
 * @create: 2019-04-02 17:59
 **/
public class Run {
    public static void main(String[] args) {
        try {
            Object lock = new Object();
            ThreadA a = new ThreadA(lock);
            a.start();

            Thread.sleep(50);

            ThreadB b = new ThreadB(lock);
            b.start();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
