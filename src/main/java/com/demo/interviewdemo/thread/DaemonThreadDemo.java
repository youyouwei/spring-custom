package com.demo.interviewdemo.thread;

import java.util.concurrent.TimeUnit;

/**
 * @Description: 守护线程
 * @Author: jiahuiyang
 * @Date: Created in 22:50 2020/3/19
 */
public class DaemonThreadDemo {

    public static void main(String[] args) throws InterruptedException {
        // 设置一个钩子线程 在jvm退出时输出日志
        Runtime.getRuntime().addShutdownHook(new Thread(()-> System.out.println("the JVM is exit success")));

        Thread thread = new Thread(() -> {
            while (true) {
                try {
                    TimeUnit.SECONDS.sleep(1);
                    System.out.println("thread is running");
                } catch (InterruptedException e) {

                }

            }


        });

        // 设置为守护线程 如果没有设置为守护线程这个线程会一直运行
        thread.setDaemon(true);

        thread.start();

        TimeUnit.SECONDS.sleep(3);

        System.out.println("the main thread is exit");
    }

}
