package com.demo.interviewdemo.dataStructureAlgorithmDemo;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Description: 利用BlockindQueue 实现多线程生产者-消费者模型
 * 阻塞队列就是:在往队列中添加元素时需要判断当前队列是否已满，如果满了就需要阻塞等待，直到有消费者消费队列后出现空闲位置，再唤醒等待线程进行添加元素的操作，反之亦然。
 *
 * @Author: jiahuiyang
 * @Date: Created in 10:40 2020/8/24
 */
public class BlockingQueueDemo {

    public static void producerAndConsumer() {
        ArrayBlockingQueue<String> blockingQueue = new ArrayBlockingQueue<String>(20, true);

        //使用原子类按照顺序标记生产者产品
        AtomicInteger atomicInteger = new AtomicInteger();

        //两个生产者几乎同时生产10产品 并且使用阻塞队列看是否会出现多线程并发问题
        new Thread(()->{

            for (int i = 0; i < 10; i++) {
                try {
                    blockingQueue.add("thread1 tom" + atomicInteger.incrementAndGet());
                    if (i == 5) {

                        Thread.sleep(100);
                    }

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }

        }).start();

        new Thread(() -> {

            for (int i = 0; i < 10; i++) {
                try {
                    blockingQueue.add("thread2 tom" + atomicInteger.incrementAndGet());

                    Thread.sleep(0);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }

        }).start();

//        try {
//            Thread.sleep(2000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }

        //使用一个新的线程几乎同时进行消费看是否会出现正常消费，正常情况下如果阻塞队列中没有对应元素会阻塞消费者消费元素

        new Thread(()->{

            for (int i = 0; i < 20; i++) {
                try {
                    //直接使用poll并未阻塞
//                    System.out.println(blockingQueue.poll());
                    //这种poll设置了等待时间 也就是阻塞时长，会等待生产者生产产品
                    System.out.println(blockingQueue.poll(100, TimeUnit.MILLISECONDS));
                    Thread.sleep(0);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }

        }).start();
    }

    public static void main(String[] args) {
        producerAndConsumer();
    }
}
