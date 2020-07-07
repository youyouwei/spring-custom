package com.feiyang.interviewdemo.thread.multiThreadDemo;

import java.util.concurrent.*;

/**
 * @description: 线程间数据交换
 * @author: jhyang
 * @create: 2019-07-01 10:19
 **/
public class ExchangerTest {
    private static final Exchanger<String> exgr = new Exchanger<>();
    private static ExecutorService threadPool = new ThreadPoolExecutor(2, 2, 0, TimeUnit.NANOSECONDS, new ArrayBlockingQueue<>(10));

    public static void main(String[] args) {


        threadPool.execute(new Runnable() {
            @Override
            public void run() {
                String A = "银行流水A";
                try {
                    exgr.exchange(A);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        });
        threadPool.execute(new Runnable() {
            @Override
            public void run() {
                try {
                    String B = "银行流水B";
                    String A = exgr.exchange(B);
                    System.out.println("A和B数据是否一致:" + A.equals(B) + "，A录入的是:" + A + "，B录入是:" + B);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        threadPool.shutdown();

    }
}
