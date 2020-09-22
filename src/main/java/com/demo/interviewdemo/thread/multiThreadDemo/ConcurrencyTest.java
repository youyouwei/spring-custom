package com.demo.interviewdemo.thread.multiThreadDemo;

/**
 * @description:
 * 并发执行和串行执行的速度比较
 * 主要看程序执行耗时
 * @author: jhyang
 * @create: 2019-06-25 15:37
 **/
public class ConcurrencyTest {
    private static final long count = 10000L;

    public static void main(String[] args) {

    }

    private static void concurrency() throws InterruptedException {
        long start = System.currentTimeMillis();
        //一部分运算分给子线程去做
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                int a = 0;
                for (int i = 0; i < count; i++) {
                    a += 5;
                }
            }
        });
        thread.start();
        //剩余一部分是主线程做
        int b = 0;
        for (int i = 0; i < count; i++) {
            b--;
        }
        long time = System.currentTimeMillis() - start;
        thread.join();
        System.out.println("concurrency :" + time + "ms,b=" + b);
    }


}
