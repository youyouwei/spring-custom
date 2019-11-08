package com.feiyang.interviewdemo.thread.createThread;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @Description:
 * @Author: jiahuiyang
 * @Date: Created in 10:35 2019/10/28
 */
public class CreateByCallable {


    public static void main(String[] args) throws ExecutionException, InterruptedException {
        createThreadByCallable();
    }

    public static void createThreadByCallable() throws ExecutionException, InterruptedException {
        FutureTask<String> futureTask = new FutureTask<>(new MyCallable());
        new Thread(futureTask,"thread 1").start();
        //可以通过回调函数获取返回值
        String res = futureTask.get();
        System.out.println(res);

    }

}

class MyCallable implements Callable<String> {

    @Override
    public String call() throws Exception {
        return "my callable";
    }
}
