package com.demo.interviewdemo.thread.multiThreadDemo;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;

/**
 * @Description: 自定义模拟Java synchronized 隐式锁
 * @Author: jiahuiyang
 * @Date: Created in 14:55 2020/4/9
 */
public class SynchronizedDemo {

    public volatile int monitor = 0;

    public List<Thread> threadList = new ArrayList<>();

    public static void main(String[] args) throws InterruptedException {
        int num = 100;
        CountDownLatch countDownLatch = new CountDownLatch(1);
        CountDownLatch end = new CountDownLatch(num);
        for (int i = 0; i < num; i++) {
            new Thread(()->{
                try {
                    countDownLatch.await();
                    //do something

                    end.countDown();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }


            });

        }

        end.await();
    }


}
