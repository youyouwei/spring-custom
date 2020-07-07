package com.feiyang.interviewdemo.thread.multiThreadDemo;

/**
 * @description:
 * join 方法目的是串行执行，调用join的线程会等待 join线程本身执行完毕再向下执行
 * @author: jhyang
 * @create: 2019-06-19 20:41
 **/
public class ThreadJoinDemo {

    public static void main(String[] args) {
        /*Thread t1 = new MyThread1();
        t1.start();

        for (int i = 0; i < 20; i++) {
            System.out.println("主线程第" + i + "次执行！");
            if (i > 2) {  //在执行到i=3时，主线程会等待子线程（join所在线程）执行完毕再向下执行
                try {
                    t1.join();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }*/



    }


    static class MyThread1 extends Thread {
        @Override
        public void run() {
            for (int i = 0; i < 10; i++) {
                System.out.println("线程1第" + i + "次执行");
            }
        }
    }

}


