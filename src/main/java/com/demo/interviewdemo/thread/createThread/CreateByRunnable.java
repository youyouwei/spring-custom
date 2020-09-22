package com.demo.interviewdemo.thread.createThread;

/**
 * @Description:
 * @Author: jiahuiyang
 * @Date: Created in 10:34 2019/10/28
 */
public class CreateByRunnable {

    public static void main(String[] args) {
        createThreadByRunnable();
    }

    public static void createThreadByRunnable() {

        new Thread(new MyRunnable(), "Thread 1").start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("new runnable");
            }
        }, "Thread 2").start();

    }
}

class MyRunnable implements Runnable {

    @Override
    public void run() {
        System.out.println("my runnable");
    }
}
