package com.demo.interviewdemo.concurrentDemo;

import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @Description: ReadWriteLock是读写锁，可以设置读锁，线程都是访问读锁的情况下可以多线程同时访问；
 * 如果是非读写锁，做不到这么智能，只能读和写都上锁，允许唯一线程访问
 *
 * @Author: jiahuiyang
 * @Date: Created in 18:27 2020/11/9
 */
public class ReadWriteLockDemo {

    public static void main(String[] args) {
        //默认是非公平  任务先进先出就是公平锁 如果是乱序就是非公平锁

//        公平锁：
//        获取不到锁的时候，会自动加入队列，等待线程释放后，队列的第一个线程获取锁
//
//        非公平锁:
//        获取不到锁的时候，会自动加入队列，等待线程释放锁后所有等待的线程同时去竞争

        ReentrantReadWriteLock reentrantReadWriteLock = new ReentrantReadWriteLock();

    }



}

class Food {

    private volatile Integer count;

    public void setCount(Integer count) {
        this.count = count;
    }

    public Integer getCount() {
        return this.count;
    }

}

class Consumer implements Runnable {

    private Lock read;

    public CyclicBarrier cyclicBarrier;

    public Consumer(Lock lock, CyclicBarrier cyclicBarrier) {
        this.read = lock;
        this.cyclicBarrier = cyclicBarrier;
    }

    @Override
    public void run() {



    }

    private void read() {

    }


}

class Producer implements Runnable {

    private Lock read;

    public CyclicBarrier cyclicBarrier;



    @Override
    public void run() {

    }
}
