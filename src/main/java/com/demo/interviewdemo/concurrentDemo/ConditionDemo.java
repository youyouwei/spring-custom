package com.demo.interviewdemo.concurrentDemo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Description: 在使用Lock之前，我们使用的最多的同步方式应该是synchronized关键字来实现同步方式了。配合Object的wait()、notify()系列方法可以实现等待/通知模式。Condition接口也提供了类似Object的监视器方法，与Lock配合可以实现等待/通知模式，但是这两者在使用方式以及功能特性上还是有差别的
 * Object 的 wait()、notify() 同步方法必须在synchronized代码块内执行，同理Lock和 Condition的使用也是绑定的，需要同时使用
 * @Author: jiahuiyang
 * @Date: Created in 11:28 2020/11/9
 */
public class ConditionDemo {

    public static final Logger LOGGER = LoggerFactory.getLogger(ConditionDemo.class);

    public static void main(String[] args) throws InterruptedException {

        Lock lock = new ReentrantLock();
        Condition condition = lock.newCondition();

        Thread work = new Thread(new Work(lock, condition));

        work.start();

        lock.lock();
        try {
            // condition 的 await 和 signal同步方法必须在lock的同步方法块内使用
            condition.await();
        }finally {
            lock.unlock();
        }



        LOGGER.info("main thread run over...");

    }

 /*   private void awaitCompletion() throws InterruptedException {
        Lock lock = new ReentrantLock();

        lock.lock();
        try {
            while (!isComplete.get()) {
                completionCondition.await();
            }
        } finally {
            lock.unlock();
        }
    }*/

}




class Work implements Runnable {

    private Lock lock;

    private Condition condition;

    public Work(Lock lock, Condition condition) {
        this.lock = lock;
        this.condition = condition;
    }

    @Override
    public void run() {

        lock.lock();

        try {
            for (int i = 0; i < 10; i++) {
                try {
                    TimeUnit.SECONDS.sleep(0);
                    ConditionDemo.LOGGER.info("work thread sleep 1 second...");

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            //唤醒 其他等待线程 进行线程间同步操作（可以用CountDownLatch）
            condition.signal();
        }finally {
            lock.unlock();
        }
    }
}
