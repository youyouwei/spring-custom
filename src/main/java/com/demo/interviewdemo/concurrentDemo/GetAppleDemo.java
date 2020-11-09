package com.demo.interviewdemo.concurrentDemo;

import java.util.concurrent.CountDownLatch;

/**
 * @Description:
 * @Author: jiahuiyang
 * @Date: Created in 22:38 2020/11/6
 */
public class GetAppleDemo {


    public static void main(String[] args) {

        Apple apple = new Apple();
        apple.setCount(9);
        CountDownLatch latch = new CountDownLatch(1);
        CountDownLatch endLatch = new CountDownLatch(2);
        Thread monkey1 = new Thread(new Monkey(2, apple, "monkey1", latch, endLatch));
        Thread monkey2 = new Thread(new Monkey(3, apple, "monkey2", latch, endLatch));
        monkey1.start();
        monkey2.start();
        latch.countDown();

        //这种方式判断多线程结束浪费cpu，并且如果线程较多不容易实现
//        while (monkey1.isAlive() || monkey2.isAlive()) {
//
//        }

        //这种方式更优雅
        try {
            endLatch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


        System.out.println("the left apples: " + apple.getCount());

    }



}

class Apple {

    private volatile Integer count;


    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }
}


class Monkey implements Runnable {

    private Integer num;

    private Apple apple;

    private String name;

    private CountDownLatch latch;

    private CountDownLatch endLatch;

    public Monkey(Integer num, Apple apple, String name, CountDownLatch latch, CountDownLatch endLatch) {
        this.num = num;
        this.apple = apple;
        this.name = name;
        this.latch = latch;
        this.endLatch = endLatch;
    }

    @Override
    public void run() {
        if (apple != null && apple.getCount() != null && apple.getCount() >= num) {
            try {
                latch.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            while (apple.getCount() >= num) {
                synchronized (Monkey.class) {
                    if (apple.getCount() >= num) {
                        apple.setCount(apple.getCount() - num);
                        System.out.println(name + ": get " + num + " apples");
                    }
                }
            }
        }
        endLatch.countDown();
    }
}

