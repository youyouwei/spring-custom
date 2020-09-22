package com.demo.interviewdemo.thread.performanceCompare;

import java.util.concurrent.CountDownLatch;

/**
 * @Description: 线程池和非线程池性能差异比较
 * @Author: jiahuiyang
 * @Date: Created in 16:39 2020/6/16
 */
public class PerformanceCompareDemo {

    private volatile static int count = 0;

    public static void main(String[] args) throws InterruptedException {
        method();

    }

    public static void method() throws InterruptedException {
        long start = System.currentTimeMillis();
        CountDownLatch countDownLatch = new CountDownLatch(1);
        for (int i = 0; i < 100; i++) {
            Thread thread = new Thread(() -> {
                try {
                    countDownLatch.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
//                count++;
                count = count + 1;
            });
            thread.start();
//            thread.join();
        }
        countDownLatch.countDown();
        long end = System.currentTimeMillis();
        System.out.println("execute time---" + (end - start));
        System.out.println("count=" + count);

       /* start = System.currentTimeMillis();
        Executor executor = Executors.newFixedThreadPool(10);
        for (int i = 0; i < 100; i++) {
            executor.execute(()->{
                count++;
            });
        }
        end = System.currentTimeMillis();
        System.out.println("execute time---" + (end - start));
        System.out.println("count=" + count);*/
    }

}
