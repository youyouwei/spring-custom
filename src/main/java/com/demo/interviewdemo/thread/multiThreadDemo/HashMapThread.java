package com.demo.interviewdemo.thread.multiThreadDemo;

import java.util.HashMap;

/**
 * @description:
 * @author: jhyang
 * @create: 2019-06-30 18:18
 **/
public class HashMapThread {
    public static void main(String[] args) throws InterruptedException {
        final HashMap<String, String> map = new HashMap<>(2);
        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 1000000; i++) {
                    new Thread(new Runnable() {
                        @Override
                        public void run() {
                            //map.put(UUID.randomUUID().toString(), "");
                        }
                    }, "ftf" + i).start();
                }

            }
        }, "ftf");
        t.start();
        t.join();

        System.out.println("finished");

    }
}
