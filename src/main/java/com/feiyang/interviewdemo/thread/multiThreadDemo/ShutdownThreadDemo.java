package com.feiyang.interviewdemo.thread.multiThreadDemo;

import java.util.concurrent.TimeUnit;

/**
 * @description:
 * 关闭线程
 * @author: jhyang
 * @create: 2019-06-27 13:46
 **/
public class ShutdownThreadDemo {
    public static void main(String[] args) throws InterruptedException {

        Runner one = new Runner();
        Thread countThread = new Thread(one, "CountThread");
        countThread.start();
        //睡眠等待一秒 然后中断线程 线程直接中断不会释放锁和其他资源
        TimeUnit.SECONDS.sleep(1);
        countThread.interrupt();

        Runner two = new Runner();
        countThread = new Thread(two, "CountThread");
        countThread.start();
        //睡眠等待一秒 然后取消循环执行 线程会释放锁和其他资源
        TimeUnit.SECONDS.sleep(1);
        two.cancel();

    }

    private static class Runner implements Runnable {

        private long i;
        private volatile boolean on = true;

        @Override
        public void run() {
            while (on && !Thread.currentThread().isInterrupted()) {
                i++;
            }
            System.out.println("Count i = " + i);
        }

        public void cancel() {
            on = false;
        }

    }

}
