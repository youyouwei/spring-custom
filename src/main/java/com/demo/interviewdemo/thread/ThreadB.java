package com.demo.interviewdemo.thread;

/**
 * @description:
 * @author: jhyang
 * @create: 2019-04-02 17:56
 **/
public class ThreadB extends Thread {
    private Object lock;

    public ThreadB(Object lock) {
        super();
        this.lock = lock;
    }

    @Override
    public void run() {
        try {
            synchronized (lock) {
                for (int i = 0; i < 10; i++) {
                    MyList.add();
                    if (MyList.size() == 5) {
                        //执行notify 并未释放锁，其他线程未能获取该对象的锁，等该线程synchronized方法块执行完释放了锁其他线程才获取锁并执行
                        lock.notify();

                        //重新使用wait会让其释放锁，进入等待队列
                        //lock.wait();
                        System.out.println("已发出通知");
                    }
                    System.out.println("添加了" + (i + 1) + "个元素");
                    Thread.sleep(1000);
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
