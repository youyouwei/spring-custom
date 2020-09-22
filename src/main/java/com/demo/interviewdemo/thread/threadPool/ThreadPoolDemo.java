package com.demo.interviewdemo.thread.threadPool;

import java.io.IOException;
import java.util.Date;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @description:
 * @author: jhyang
 * @create: 2019-06-06 15:44
 **/
public class ThreadPoolDemo {

    public static void main(String[] args) throws IOException {
        //Executor executor = null;

        int corePoolSize = 2;
        int maximumPoolSize = 4;
        long keepAliveTime = 10;
        TimeUnit unit = TimeUnit.SECONDS;
        System.out.println(unit.toMinutes(60));

        BlockingQueue<Runnable> workQueue = new ArrayBlockingQueue<>(5);
        ThreadFactory threadFactory = new NameThreadFactory();
        RejectedExecutionHandler handler = new MyIgnorePolicy();
        ThreadPoolExecutor executor1 = new ThreadPoolExecutor(corePoolSize, maximumPoolSize, keepAliveTime, unit, workQueue, threadFactory, handler);
        executor1.prestartAllCoreThreads();
        for (int i = 0; i < 10; i++) {
            //在线程池中加入执行任务  应为是两个阻塞队列，会出现两个两个的执行，并且如果超出的化会
            //并且最多出现4个线程被创建
            //所以4个线程 和 2 个等待队列 一共会有6个任务可被执行，剩下的任务被拒绝策略处理
            //所有线程池最大可执行任务数量是 最大线程数+等待队列数
            MyTask task = new MyTask(String.valueOf(i));
            executor1.execute(task);
        }
        //阻塞主线程
        System.in.read();


        //final AtomicInteger atomicInteger = new AtomicInteger(1);
        //System.out.println(atomicInteger);
        //System.out.println(atomicInteger.incrementAndGet());


        //定时任务
        //ThreadFactory threadFactory = new NameThreadFactory();
        //CountDownLatch latch = new CountDownLatch(1);
        //MyTask task = new MyTask("sss");
        //ScheduledExecutorService executorService = new ScheduledThreadPoolExecutor(2, threadFactory);
        ////任务每隔5秒执行一次
        //executorService.scheduleAtFixedRate(task, 0, 5, TimeUnit.SECONDS);





    }


    static class NameThreadFactory implements ThreadFactory {

        private final AtomicInteger mThreadNum = new AtomicInteger(1);

        @Override
        public Thread newThread(Runnable runnable) {
            Thread t = new Thread(runnable, "my-thread-" + mThreadNum.getAndIncrement());
            System.out.println(t.getName() + " has been created");
            return t;
        }
    }

    /**
     * 当任务队列满时 自定义拒绝策略
     */
    static class MyIgnorePolicy implements RejectedExecutionHandler {
        @Override
        public void rejectedExecution(Runnable runnable, ThreadPoolExecutor threadPoolExecutor) {
            doLog(runnable, threadPoolExecutor);
        }

        private void doLog(Runnable r, ThreadPoolExecutor executor) {
            //可做日志记录等
            System.err.println(r.toString() + " rejected");
        }
    }

    static class MyTask implements Runnable {

        private String name;

        public MyTask(String name) {
            this.name = name;
        }

        @Override
        public void run() {
            try {
                System.out.println(this.toString() + " is running!" + new Date());
                Thread.sleep(3000);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        public String getName() {
            return name;
        }

        @Override
        public String toString() {
            return "MyTask [name=" + name + "]";
        }
    }

}
