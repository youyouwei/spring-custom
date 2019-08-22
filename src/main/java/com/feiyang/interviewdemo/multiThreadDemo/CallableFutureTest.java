package com.feiyang.interviewdemo.multiThreadDemo;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @description:
 * Future 获取线程返回结果
 * @author: jhyang
 * @create: 2019-06-30 22:54
 **/
public class CallableFutureTest {

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        Callable<Integer> callable = new Callable<Integer>() {
            @Override
            public Integer call() throws Exception {
                Thread.sleep(2000);
                return 1 + 2;
            }
        };

        FutureTask<Integer> task = new FutureTask<>(callable);
        Thread thread = new Thread(task);
        thread.start();
        try {
            Thread.sleep(3000);
            //int a = 3 + 5;
            Integer result = task.get();
            System.out.println(result);

        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }

    }

}
