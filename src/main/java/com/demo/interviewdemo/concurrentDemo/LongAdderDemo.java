package com.demo.interviewdemo.concurrentDemo;

import org.jetbrains.annotations.NotNull;

import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.LongAdder;

/**
 * @Description:
 * @Author: jiahuiyang
 * @Date: Created in 21:03 2020/11/15
 */
public class LongAdderDemo {

    public static void main(String[] args) {
        // LongAdder初始值是0
        LongAdder longAdder = new LongAdder();

        System.out.println(longAdder.toString());

        longAdder.add(9L);

        System.out.println(longAdder.toString());

        //恢复到初始值0
        longAdder.reset();

        System.out.println(longAdder.toString());

        longAdder.add(-1);

        System.out.println(longAdder.toString());

        TimeUnit unit;
        BlockingQueue workQueue;

        //
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(
                Runtime.getRuntime().availableProcessors(),
                Runtime.getRuntime().availableProcessors(),
                1000 * 60,
                TimeUnit.MILLISECONDS,
                new LinkedBlockingQueue<Runnable>(50000),
                new ThreadFactory() {
                    private AtomicInteger threadIndex = new AtomicInteger(0);

                    @Override
                    public Thread newThread(Runnable r) {
                        return new Thread(r, "CustomerThreadPoolExecutor_" + this.threadIndex.incrementAndGet());
                    }

                });

        //或则直接指定核心线程数
        ThreadPoolExecutor otherThreadPool = new ThreadPoolExecutor(0, 1, 60, TimeUnit.SECONDS,
                new LinkedBlockingQueue<Runnable>(2),
                new ThreadFactory() {

                    @Override
                    public Thread newThread(Runnable r) {
                        return new Thread(r, "SimpleCachedLDAPAuthorizationMap update thread");
                    }
                });


        // 默认就是false 如果是true 就是在没有任务后 超过等待时间就是销毁线程，否则就是一直存在等待新任务的到来
        threadPoolExecutor.allowCoreThreadTimeOut(false);
        threadPoolExecutor.setRejectedExecutionHandler(new ThreadPoolExecutor.DiscardPolicy());


        Runtime.getRuntime().addShutdownHook(new Thread((()->{
            threadPoolExecutor.shutdown();
            try {
                threadPoolExecutor.awaitTermination(10, TimeUnit.MINUTES);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        })));


        System.out.println();
        System.err.println();





    }





}
