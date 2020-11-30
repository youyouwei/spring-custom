package com.demo.interviewdemo.concurrentDemo;

import java.io.IOException;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @Description:
 * @Author: jiahuiyang
 * @Date: Created in 14:37 2020/11/18
 */
public class ThreadPoolExecutorDemo {

    public static void main(String[] args) throws IOException, InterruptedException {

        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(Runtime.getRuntime().availableProcessors(), Runtime.getRuntime().availableProcessors() << 1, 10, TimeUnit.SECONDS, new LinkedBlockingDeque<>(100));

        //线程池初始化后 并没有创建线程 在有任务执行execute后 才会创建线程；在任务执行完成或则抛出异常后也不会终止线程，已创建的线程就会进入WAITING等待状态；
        threadPoolExecutor.execute(()->{
            System.out.println(Thread.currentThread().getName() + ": " + "the first task......");

            throw new RuntimeException("error in first task");
        });


        threadPoolExecutor.execute(() -> System.out.println(Thread.currentThread().getName() + ": " + "the second task...."));

        threadPoolExecutor.submit(() -> System.out.println(Thread.currentThread().getName() + ": " + "the third task....."));

        TimeUnit.SECONDS.sleep(2);

        System.in.read();





    }

}
