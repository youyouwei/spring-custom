package com.demo.interviewdemo.thread.multiThreadDemo.connectionPool;

import java.sql.Connection;
import java.util.LinkedList;

/**
 * @description:
 * @author: jhyang
 * @create: 2019-06-27 17:05
 **/
public class ConnectionPool {

    //使用linkList作为数据库连接池的容器
    //作为一个队列处理 先进先出

    private LinkedList<Connection> pool = new LinkedList<>();

    public ConnectionPool(int initialSize) {
        if (initialSize > 0) {
            for (int i = 0; i < initialSize; i++) {
                //使用数据库连接驱动创建数据库连接connection
                pool.addLast(ConnectionDriver.createConnection());
            }
        }
    }

    /**
     * 释放连接并且 唤醒等待的线程
     * @param connection
     */
    public void releaseConnection(Connection connection) {
        if (connection != null) {
            synchronized (pool) {
                //调用者释放数据库连接，使用者把数据库连接还回来，并且唤醒等待的线程
                pool.addLast(connection);
                pool.notifyAll();
            }
        }
    }

    /**
     * 获取连接池的连接 并且设置获取超时时间，如果超过该时间返回null
     * @param mills
     * @return
     * @throws InterruptedException
     */
    public Connection fetchConnection(long mills) throws InterruptedException {
        //设置线程池为对象锁 每次只有一个线程获取数据库连接
        synchronized (pool) {
            //完全超时 设置超时小于等于0 相当于不设置超时处理 如果没有就等待 等待别人释放资源后唤醒 再竞争判断
            if (mills <= 0) {
                while (pool.isEmpty()) {
                    pool.wait();
                }
                //从队列中移除第一个连接
                return pool.removeFirst();
            } else {
                //有超时限制 如果超过就返回 null
                //future 到时时间
                long future = System.currentTimeMillis() + mills;
                //还剩余时间
                long remaining = mills;
                while (pool.isEmpty() && remaining > 0) {
                    pool.wait(remaining);
                    //每次等待后重新计算还剩余时间
                    remaining = future - System.currentTimeMillis();
                }
                Connection result = null;
                //如果到时间 连接池为空就返回null
                if (!pool.isEmpty()) {
                    //从队列中移除第一个连接
                    result = pool.removeFirst();
                }
                return result;
            }
        }
    }
}
