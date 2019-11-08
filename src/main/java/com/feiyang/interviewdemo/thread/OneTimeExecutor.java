package com.feiyang.interviewdemo.thread;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @Description: executor at one time
 * @Author: jiahuiyang
 * @Date: Created in 10:15 2019/10/28
 */
public class OneTimeExecutor {
    CountDownLatch countDownLatch = new CountDownLatch(1);
    private  void runThread(){
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        for(int i=0;i<10 ;i++){
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            // 线程池提交运行任务
            executorService.submit(new Runnable() {
                @Override
                public void run() {
                    try {
                        countDownLatch.await();
                        System.out.println("Thread:"+Thread.currentThread().getName()+",time: "+System.currentTimeMillis());
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            });
        }
        //
        countDownLatch.countDown();
    }

    public static void main(String[] args) {
        OneTimeExecutor test = new OneTimeExecutor();
        test.runThread();
    }
}
