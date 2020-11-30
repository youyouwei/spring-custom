package com.demo.interviewdemo.thread;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;

import java.util.concurrent.TimeUnit;

/**
 * @Description:
 * @Author: jiahuiyang
 * @Date: Created in 22:54 2020/11/17
 */
public class ThreadExceptionDemo {

    private final static Logger LOGGER = LoggerFactory.getLogger(ThreadExceptionDemo.class);

    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(() -> {
            try {
                System.out.println("thread exception catch by main thread");
                throw new RuntimeException("some thing is wrong!!!");

            } catch (Exception e) {
                //这种是单个任务的异常处理
                LOGGER.error("sss===============", e);
            }
        });

        //这种适合所有任务进行统一异常处理
        thread.setUncaughtExceptionHandler((t, e) -> {
            if (e instanceof InterruptedException ||
                    (e.getCause() != null && e.getCause() instanceof InterruptedException)) {
                //线程被中断
                return;
            }

            LOGGER.error("from " + t.getName(), e);

        });


        //无法通过catch start 进行异常处理
        try {
//            thread.start();
        } catch (Exception e) {
            System.out.println("main thread catch child thread exception!!!");
        }


        Thread threadOther = new Thread(()->{
            System.out.println("child thread throw exception");
            throw new RuntimeException("some thing wrong with child thread");
        });


        try {
            //正常情况下主线程是无法捕捉到子线程中出现的异常 可以在任务中捕捉处理异常 或则通过setUncaughtExceptionHandler
            threadOther.start();
        } catch (Exception e) {
            System.out.println("main thread catch child thread exception");
        }



        TimeUnit.SECONDS.sleep(10);


    }

}
