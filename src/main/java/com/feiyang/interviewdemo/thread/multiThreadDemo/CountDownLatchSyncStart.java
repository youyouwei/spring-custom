package com.feiyang.interviewdemo.thread.multiThreadDemo;

import java.util.concurrent.CountDownLatch;

/**
 * @description:
 * @author: jhyang
 * @create: 2019-08-07 15:51
 **/
public class CountDownLatchSyncStart {
    @SuppressWarnings("unchecked")
    public static void main(String[] args) throws InterruptedException {
        CountDownLatchSyncStart test = new CountDownLatchSyncStart();
        CountDownLatch latch = new CountDownLatch(1);
        for (int i = 0; i < 10; i++) {
            Thread t1 = new Thread(test.new MapOper(latch));
            t1.setName("Thread" + i);
            t1.start();
        }

        System.out.println("thread always start, sleep for a while...");

        Thread.sleep(1000);
        latch.countDown();
    }

    public class MapOper implements Runnable {

        CountDownLatch latch;

        public MapOper(CountDownLatch latch) {
            this.latch = latch;
        }

        @Override
        public void run() {
            try {
                latch.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + " Sync Started");
        }
    }

}
