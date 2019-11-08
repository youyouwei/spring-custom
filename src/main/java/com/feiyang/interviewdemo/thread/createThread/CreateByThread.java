package com.feiyang.interviewdemo.thread.createThread;

/**
 * @Description:
 * @Author: jiahuiyang
 * @Date: Created in 10:34 2019/10/28
 */
public class CreateByThread {

    public static void main(String[] args) {
        createThreadByThread();
    }

    public static void createThreadByThread() {

        new MyThread("Thread 1").start();
        new Thread(new MyThread("Thread 2")).start();


    }

}

class MyThread extends Thread {

    public MyThread() {
        //可以不显式调用 默认调用无参构造
//        super();
    }

    public MyThread(String name) {
        super(name);
    }

    @Override
    public void run() {
        System.out.println("my thread "+currentThread().getName());
    }

}


