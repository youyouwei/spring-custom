package com.feiyang.interviewdemo.thread.threadPool;

import com.feiyang.interviewdemo.thread.Run;
import org.jetbrains.annotations.NotNull;

import java.util.concurrent.*;

/**
 * @Description: 线程池 操作
 * 参考 https://blog.csdn.net/u013217730/article/details/107408327
 * @Author: jiahuiyang
 * @Date: Created in 20:48 2020/4/22
 */
public class ThreadPool {

    public static void main(String[] args) {
//        method1();

//        Runnable是一个函数接口 主要作为任务类传入在Thread中执行,其中Thread也是实现了改接口也可以接受Runnable接口的入参
       /* Runnable runnable = new Runnable() {

            @Override
            public void run() {
                System.out.println("name tom");

            }
        };
        runnable.run();

        Thread thread = new Thread();
        thread.run();
        */

    }

    /**
     *
     */
    public static void method() {
        ExecutorService executorService = new ThreadPoolExecutor(10, 10, 0, TimeUnit.SECONDS, new ArrayBlockingQueue<>(100), new ThreadFactory() {
            @Override
            public Thread newThread(@NotNull Runnable r) {
                return new Thread(Thread.currentThread().getThreadGroup(), r, "ThreadPool");
            }
        }, new RejectedExecutionHandler(){

            @Override
            public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
                new RuntimeException("任务超过最大限制！");

            }
        });

        ((ThreadPoolExecutor) executorService).allowCoreThreadTimeOut(false);

    }


    /**
     * 测试可执行最大任务数，实现RejectedExecutionHandler如果超过最大任务数抛出异常
     * 最大执行任务数是 最大线程数+任务队列大小
     *
     */
    public static void method1() {

        ExecutorService executorService = new ThreadPoolExecutor(2, 3, 0, TimeUnit.SECONDS, new ArrayBlockingQueue<>(10), new ThreadFactory() {
            @Override
            public Thread newThread(@NotNull Runnable r) {
                return new Thread(Thread.currentThread().getThreadGroup(), r, "ThreadPoolNew");
            }
        }, new RejectedExecutionHandler() {
            @Override
            public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
//                如果线程池抛出异常 关闭线程池使主线程能够退出
                executor.shutdown();
                throw new RuntimeException("任务超过最大限制！");
            }
        });

        for (int i = 0; i < 20; i++) {
            final int sequence = i;
            executorService.execute(new Runnable() {
                @Override
                public void run() {
                    System.out.println("任务执行序号：" + sequence);
                }
            });
        }

//        如果线程池正常执行结束会调用该方法
        executorService.shutdown();

    }

    public static void method2() {

    }

}
