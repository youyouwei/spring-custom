package com.feiyang.interviewdemo.thread.multiThreadDemo;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @description:
 * @author: jhyang
 * @create: 2019-06-28 10:45
 **/
public class Main {
    /**
     * 包装一个数字
     */
    static class NumberWrapper {
        public int value = 1;
    }

    public static void main(String[] args) {
        final Lock lock = new ReentrantLock();

        final Condition reachThreeCondition = lock.newCondition();
        final Condition reachSixCondition = lock.newCondition();

        final NumberWrapper num = new NumberWrapper();

        Thread threadA = new Thread(new Runnable() {
            @Override
            public void run() {
                lock.lock();
                try {
                    System.out.println("threadA start write");
                    while (num.value <= 3) {
                        System.out.println(num.value);
                        num.value++;
                    }
                    reachThreeCondition.signal();
                }finally {
                    lock.unlock();
                }
                lock.lock();
                try {
                    reachSixCondition.await();
                    System.out.println("threadA start write");
                    while (num.value <= 9) {
                        System.out.println(num.value);
                        num.value++;
                    }

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }finally {
                    lock.unlock();
                }
            }
        });

        Thread threadB = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    lock.lock();
                    while (num.value <= 3) {
                        reachThreeCondition.await();
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }finally {
                    lock.unlock();
                }
                try {
                    lock.lock();
                    System.out.println("threadB start write");
                    while (num.value <= 6) {
                        System.out.println(num.value);
                        num.value++;
                    }
                    reachSixCondition.signal();
                }finally {
                    lock.unlock();
                }
            }
        });

        //启动两个线程
        threadB.start();
        threadA.start();

    }


}
