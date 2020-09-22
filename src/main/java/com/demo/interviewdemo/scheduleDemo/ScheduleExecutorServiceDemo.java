package com.demo.interviewdemo.scheduleDemo;

import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @description:
 * 使用 juc 中的 ScheduleExecutorService
 * @author: jhyang
 * @create: 2019-06-19 15:58
 **/
public class ScheduleExecutorServiceDemo {

    public static void main(String[] args) {
        //ScheduledExecutorService executorService = new ScheduledThreadPoolExecutor(1, new basict);


        ScheduledExecutorService executorService = new ScheduledThreadPoolExecutor(1);

        executorService.schedule(new Runnable() {
            @Override
            public void run() {

                System.out.println("只执行一次");
            }
        }, 5000, TimeUnit.MILLISECONDS);


        //executorService.shutdown();  //线程池中任务执行完后会执行关闭线程池操作

        executorService.shutdownNow(); //线程池直接立即关闭，不会等待线程池中的任务执行完毕




    }

}
