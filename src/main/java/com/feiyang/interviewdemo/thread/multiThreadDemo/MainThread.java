package com.feiyang.interviewdemo.thread.multiThreadDemo;

import java.math.BigDecimal;

/**
 * @description:
 * @author: jhyang
 * @create: 2019-06-21 16:45
 **/
public class MainThread {

    public static void main(String[] args) throws InterruptedException {
       /* int threadNum = 5;
        CountDownLatch runningThreadNum = new CountDownLatch(threadNum);
        System.out.println("子线程开始");

        //如果是守护线程 在其他非守护线程执行完成后 守护线程才退出

        for (int i = 0; i < threadNum; i++) {
            new SubThread(runningThreadNum).start();
        }

        //await如果统计0才能返回方法继续执行
        runningThreadNum.await();
        System.out.println("子线程结束");*/

        BigDecimal bigDecimal = BigDecimal.valueOf(10);

        System.out.println(bigDecimal);



    }

}
