package com.demo.interviewdemo.thread.multiThreadDemo;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @description:
 * 有界缓冲区问题
 * lock 可以创建多个condition 来监控不同情形
 * @author: jhyang
 * @create: 2019-06-28 10:31
 **/
public class BoundedBuffer {
    final Lock lock = new ReentrantLock();           //锁对象
    final Condition notFull = lock.newCondition();   //写线程条件
    final Condition notEmpty = lock.newCondition();  //读线程条件

    final Object[] items = new Object[100];  //缓存队列
    int putptr /*写索引*/, takeptr /*读索引*/ ;  //初始化默认值是0

    AtomicInteger count /*队列中存在的数据个数*/;   //读写线程同时处理count 使用原子操作

    /**
     * 写
     * @param x
     * @throws InterruptedException
     */
    public void put(Object x) throws InterruptedException {
        lock.lock();
        try {
            while (count.get() == items.length) {  //队列已写满线程进入等待
                notFull.await();
            }
            items[putptr] = x;
            if (++putptr == items.length) {  //如果索引走到操作队列限度 重新归零
                putptr = 0;
            }
            count.incrementAndGet();  //队列值加一
            //++count;
            notEmpty.signal();//唤醒存在等待的读线程

        }finally {
            lock.unlock();
        }
    }

    /**
     * 读
     * @return
     * @throws InterruptedException
     */
    public Object take() throws InterruptedException {
        lock.lock();
        try {
            while (count.get() == 0) {  //队列已空 进入等待
                notEmpty.await();
            }
            Object x = items[takeptr];    //取出当前索引的值
            if (++takeptr == items.length) {  //如果取索引超过最大值 重新归零
                takeptr = 0;
            }
            count.decrementAndGet();  //队列值减一
            //--count;
            notFull.signal();  //唤醒存在等待状态的写线程
            return x;
        }finally {
            lock.unlock();
        }
    }
}
