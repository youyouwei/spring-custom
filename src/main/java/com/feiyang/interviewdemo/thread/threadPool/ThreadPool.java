package com.feiyang.interviewdemo.thread.threadPool;

import org.jetbrains.annotations.NotNull;

import java.util.concurrent.*;

/**
 * @Description: 线程池 操作
 * @Author: jiahuiyang
 * @Date: Created in 20:48 2020/4/22
 */
public class ThreadPool {

    public static void main(String[] args) {

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
        });





    }

}
