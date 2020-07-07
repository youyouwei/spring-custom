package com.feiyang.interviewdemo.thread.multiThreadDemo;

/**
 * @description:
 * @author: jhyang
 * @create: 2019-06-21 20:17
 **/
public class WaitNotifyDemo {

    static class Thread1 implements Runnable {

        @Override
        public void run() {
            synchronized (WaitNotifyDemo.class) {
                System.out.println("enter thread1 ...");

                System.out.println("thread1 is waiting");
                try {
                    WaitNotifyDemo.class.wait();

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("thread1 is going on...");
                System.out.println("thread1 is being over!");

            }
        }
    }

    private static class Thread2 implements Runnable {
        @Override
        public void run() {

            synchronized (WaitNotifyDemo.class) {
                System.out.println("enter thread2 ...");
                System.out.println("thread2 notify other threads...");

                //唤醒其中一个wait 状态线程 notifyAll 是唤醒所有wait 状态线程
                WaitNotifyDemo.class.notify();
                System.out.println("thread2 is sleeping ten seconds");
                try {

                    Thread.sleep(10);

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                System.out.println("thread2 is going on...");
                System.out.println("thread2 is being over!");

            }

        }
    }


    public static void main(String[] args) {
        new Thread(new Thread1()).start();
        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        new Thread(new Thread2()).start();

        Class c = WaitNotifyDemo.class;

        Class c1 =WaitNotifyDemo.class;

        Class c2 = WaitNotifyDemo.class;


        //Condition condition =


    }




}
