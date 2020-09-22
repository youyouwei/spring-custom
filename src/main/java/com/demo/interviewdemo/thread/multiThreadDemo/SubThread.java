package com.demo.interviewdemo.thread.multiThreadDemo;

import java.util.concurrent.CountDownLatch;

/**
 * @description: 子线程
 * @author: jhyang
 * @create: 2019-06-21 16:43
 **/
public class SubThread extends Thread {
    private CountDownLatch runningThreadNum;

    public SubThread(CountDownLatch runningThreadNum) {
        this.runningThreadNum = runningThreadNum;
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + "-start");
        System.out.println(Thread.currentThread().getName() + "-doSomething");
        System.out.println(Thread.currentThread().getName() + "-end");

        runningThreadNum.countDown();
    }
}
