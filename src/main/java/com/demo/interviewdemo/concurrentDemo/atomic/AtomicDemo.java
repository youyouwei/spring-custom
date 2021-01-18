package com.demo.interviewdemo.concurrentDemo.atomic;

import com.google.common.base.Stopwatch;

import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Description:  通过 atomic 原子类操作 可以避免显示加锁 如果只是单纯的数字加减
 * @Author: jiahuiyang
 * @Date: Created in 13:49 2020/11/15
 */
public class AtomicDemo {


    public static void main(String[] args) throws InterruptedException {
        Stopwatch stopwatch = Stopwatch.createStarted();
        AtomicInteger atomicInteger = new AtomicInteger(9);


        // Semaphore保证 能同时执行的最大线程数 相当于操作系统的信号量
        // 如果信号量为0 那么其他线程获取时就会被阻塞 直到有线程release释放信号量

        // 和lock 相比semaphore能够允许多线程同时访问临界区资源，lock只能允许一个线程访问
        Semaphore semaphore = new Semaphore(2);

        // cyclicBarrier 控制多线程同时开始 也可以通过reset进行重新循环一轮
        CyclicBarrier cyclicBarrier = new CyclicBarrier(2);

        //countDownLatch 控制同时结束 和主线程就行同步
        CountDownLatch countDownLatch = new CountDownLatch(2);
        new Thread(() ->{
            try {
                cyclicBarrier.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (BrokenBarrierException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName()+": "+stopwatch.toString());
            while (atomicInteger.get() >= 2) {
                atomicInteger.addAndGet(-2);
                System.out.println("-2");
            }
            countDownLatch.countDown();
        },"thread1").start();

        new Thread(() -> {
            try {
                cyclicBarrier.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (BrokenBarrierException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName()+": "+stopwatch.toString());
            while (atomicInteger.get() >= 3) {
                atomicInteger.addAndGet(-3);
                System.out.println("-3");
            }
            countDownLatch.countDown();
        },"thread2").start();

//        TimeUnit.SECONDS.sleep(4);

        //等待多线程执行结束
        countDownLatch.await();

        System.out.println(atomicInteger.get());

        stopwatch.stop();
        System.out.println(stopwatch.elapsed(TimeUnit.MILLISECONDS));


    }

}
