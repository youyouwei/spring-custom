package com.feiyang.interviewdemo.thread.synchronizedDemo;

import java.util.concurrent.CountDownLatch;

/**
 * @description:
 * @author: jhyang
 * @create: 2019-06-24 16:13
 **/
public class AutoIncrementDemo {

    private volatile int counter;  //volatile 不能实现原子操作

    public int getCounter() {
        return counter;
    }

    public void setCounter(int i) {
        this.counter = i;
    }

    public synchronized void incr() {   //使用monitor synchronized 可以保证count++ 的原子操作
        counter++;
    }

    /**
     * 使用类成员属性 作为自增的内容
     * @param args
     * @throws InterruptedException
     */
    public static void main(String[] args) throws InterruptedException {

        for (int i = 0; i < 10; i++) {
            final AutoIncrementDemo autoIncrementDemo = new AutoIncrementDemo();
            final CountDownLatch countDownLatch = new CountDownLatch(10000);
            for (int j = 0; j < 10000; j++) {
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        for (int k = 0; k < 100; k++) {
                            try {
                                Thread.sleep(10);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }

                        }
                        autoIncrementDemo.incr();
                        countDownLatch.countDown();
                    }
                }).start();
            }

        //    主线程等待子线程结束
            countDownLatch.await();
            System.out.println(autoIncrementDemo.getCounter());


        }
        //输出内容 测试10次 每次都不是10000 所以i++不是原子操作
        //9983
        //9984
        //9975
        //9984
        //9990
        //9986
        //9978
        //9967
        //9979
        //9983
    }

}
