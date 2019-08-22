package com.feiyang.interviewdemo.multiThreadDemo.connectionPool;

import java.sql.Connection;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @description:
 * @author: jhyang
 * @create: 2019-06-27 17:22
 **/
public class ConnectionPoolTest {

    //初始化10个连接的数据库连接池

    static ConnectionPool pool = new ConnectionPool(10);

    //保证所有ConnectionRunner能够同时开始

    static CountDownLatch start = new CountDownLatch(1);

    //main线程将会等待所有ConnectionRunner结束后才能继续执行

    static CountDownLatch end;

    public static void main(String[] args) throws InterruptedException {
        int threadCount = 30;
        end = new CountDownLatch(threadCount);
        int count = 20;
        AtomicInteger got = new AtomicInteger();
        AtomicInteger notGot = new AtomicInteger();
        for (int i = 0; i < threadCount; i++) {
            Thread thread = new Thread(new ConnectionRunner(count, got, notGot),"ConnectionRunnerThread");
            thread.start();
        }
        start.countDown();
        end.await();
        System.out.println("total invoke: " + (threadCount * count));
        System.out.println("got connection: " + got);
        System.out.println("not got connection: " + notGot);

    }

    static class ConnectionRunner implements Runnable {

        int count;           //每个connnectionRunner 需要的连接数
        AtomicInteger got;
        AtomicInteger notGot;

        public ConnectionRunner(int count, AtomicInteger got, AtomicInteger notGot) {
            this.count = count;
            this.got = got;
            this.notGot = notGot;
        }


        @Override
        public void run() {

            try {
                //保证多线程同时往下执行
                //await()是CountDownLatch为零的时候继续向下执行，否则一直等待
                start.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            while (count > 0) {
                try {
                    //获取连接 并且设置1秒的获取连接超时期限
                    Connection connection = pool.fetchConnection(1000);
                    if (connection != null) {
                        try {
                            //获取数据库连接后的数据库操作
                            connection.createStatement();  //Statement相当于一个数据容器
                            connection.commit();           //commit 提交事务操作  如果设置了auto commit,即不需要手动调用
                        } finally {
                            pool.releaseConnection(connection);  //释放连接
                            got.incrementAndGet();               //获取连接成功的计数加一
                        }
                    } else {
                        notGot.incrementAndGet();  //获取连接失败的计数减一
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }finally {
                    count--;
                }

            }
            end.countDown();
        }
    }

}
