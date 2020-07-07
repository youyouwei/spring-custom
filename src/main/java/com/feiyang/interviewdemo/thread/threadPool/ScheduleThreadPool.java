package com.feiyang.interviewdemo.thread.threadPool;

import java.io.IOException;
import java.util.Date;
import java.util.concurrent.*;

/**
 * @description:
 * @author: jhyang
 * @create: 2019-06-06 16:54
 **/
public class ScheduleThreadPool {
    public static void main(String[] args) throws IOException {

        //子线程未执行完，主线程不能关闭

        ScheduledThreadPoolExecutor executor = new ScheduledThreadPoolExecutor(10);
        System.out.println(new Date());
        executor.schedule( new MyTask(), 1, TimeUnit.SECONDS);
        System.out.println(new Date());





        //Executor executor = new ThreadPoolExecutor(1, 1, 0, TimeUnit.SECONDS, new LinkedBlockingDeque<>());
        //executor.execute(new Runnable() {
        //    @Override
        //    public void run() {
        //        System.out.println("sss");
        //
        //    }
        //});
        ////关闭线程池，不然主线程一直等待线程池执行完毕
        //((ThreadPoolExecutor) executor).shutdown();


        //for (int i = 0; i < 100; i++) {
        //    new Thread(new Runnable() {
        //        @Override
        //        public void run() {
        //            System.out.println("执行1秒");
        //            try {
        //                Thread.sleep(10000);
        //            } catch (InterruptedException e) {
        //                e.printStackTrace();
        //            }
        //        }
        //    }).start();
        //}

        //System.in.read();

    }

    static class MyTask implements Runnable {
        @Override
        public void run() {
            System.out.println("定时延迟10秒执行！");
        }
    }

}
