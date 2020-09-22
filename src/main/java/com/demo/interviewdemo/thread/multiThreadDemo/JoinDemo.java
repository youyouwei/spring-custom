package com.demo.interviewdemo.thread.multiThreadDemo;

import java.util.Date;

/**
 * @description:
 * @author: jhyang
 * @create: 2019-06-21 15:46
 **/
public class JoinDemo {
    public static void main(String[] args) throws InterruptedException {

        System.out.println("开始执行线程！");
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {

                System.out.println("次线程开始执行！");
                Thread thread1 = new Thread(new Runnable() {
                    @Override
                    public void run() {
                        for (int i = 0; i < 100; i++) {
                            try {
                                Thread.sleep(1000);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                            System.out.println(new Date());
                        }
                    }
                });
                thread1.start();
                System.out.println("次线程执行完毕！");
            }
        });


        thread.start();

        //thread.join();      //主线程会等待子线程执行再继续向下执行  使后续执行为串行
        //thread.join(5000);    //如果没有参数 代表等待直到子线程执行完毕，有参数表示等待一段时间然后主线程继续向下执行
        //如果没有join 主线程中的代码会正常执行，并且等待子线程完成后主线程结束

        System.out.println(Thread.currentThread().isDaemon());
        System.out.println("主线程执行完成！");




    }






}
