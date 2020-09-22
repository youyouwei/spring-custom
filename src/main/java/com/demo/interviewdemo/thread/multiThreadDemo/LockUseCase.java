package com.demo.interviewdemo.thread.multiThreadDemo;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @description:
 * lock 锁使用
 * @author: jhyang
 * @create: 2019-06-28 09:50
 **/
public class LockUseCase {

    public static void main(String[] args) throws InterruptedException {
        //创建锁和获取锁要在try 外层，防止创建和获取锁的时候出现异常 直接执行finally 中的代码
        //Reentrant可重入锁
        Lock lock = new ReentrantLock();
        Condition condition = lock.newCondition();
        lock.lock();

        System.out.println("线程进入等待");

        //一个线程阻塞一个线程唤醒
        //阻塞线程
        condition.await();

        //唤醒线程
        condition.signal();


        System.out.println("获得锁");
        try {

        }finally {
            //最后要在finally 中释放锁 目的是保证获取锁之后要能释放锁
            lock.unlock();
            System.out.println("释放锁");
        }
    }
}
