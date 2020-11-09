package com.demo.interviewdemo.concurrentDemo;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.TimeUnit;

/**
 * @Description: 使用CyclicBarrier来等待多线程同时执行，也可以通过CountDownLatch来完成
 * 也可以控制多线程执行和主线程同步执行：等待多线程执行完后执行主线程
 *
 * 有两种方法，可以应对不同的情况：
 *
 * 分别是CountDownLatch和CyclicBarrier
 *
 * @Author: jiahuiyang
 * @Date: Created in 14:30 2020/11/9
 */
public class CyclicBarrierDemo {

    public static void main(String[] args) throws BrokenBarrierException, InterruptedException {

        CyclicBarrier barrier = new CyclicBarrier(2);
        Thread thread = new Thread(new Dog(barrier),"dog1");
        thread.start();
        barrier.await();
        System.out.println(Thread.currentThread().getName() + ": " + System.currentTimeMillis());


    }

}

class Dog implements Runnable {

    private CyclicBarrier barrier;

    public Dog(CyclicBarrier barrier) {
        this.barrier = barrier;
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + ": " + System.currentTimeMillis());
        try {
            TimeUnit.SECONDS.sleep(1);

            barrier.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (BrokenBarrierException e) {
            e.printStackTrace();
        }
    }
}
