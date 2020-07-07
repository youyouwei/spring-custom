package com.feiyang.interviewdemo.thread.multiThreadDemo;

/**
 * @Description: 多线程处理一个任务时对共享变量进行隔离
 * @Author: jiahuiyang
 * @Date: Created in 18:29 2020/4/9
 */
public class ThreadLocalDemo {

    public static void main(String[] args) {
        MyRunnable runnable = new MyRunnable();
        Thread thread = new Thread(runnable);
        Thread threadOther = new Thread(runnable);
        thread.start();
        threadOther.start();

        MyNormalRunnable myNormalRunnable = new MyNormalRunnable();
        myNormalRunnable.setName("thread1");
        Thread thread1 = new Thread(myNormalRunnable);
//        线程之间修改变量相互影响
        myNormalRunnable.setName("thread2");
        Thread thread2 = new Thread(myNormalRunnable);
        thread1.start();
        thread2.start();

    }

    static class MyRunnable implements Runnable {

        private ThreadLocal<Integer> local = new ThreadLocal<>();

        @Override
        public void run() {
            local.set((int) (Math.random() * 1000));
            try {
                Thread.sleep(2000);

            } catch (InterruptedException e) {

            }

            //如果不是ThreadLocal 当前线程会输出最后一个修改local的值 ，如果同时输出基本上输出时一致的
            System.out.println("ThreadLocal value :" + local.get());
        }
    }

    static class MyNormalRunnable implements Runnable {

        private String name = "default";

        public void setName(String name) {
            this.name = name;
        }

        @Override
        public void run() {
            try {
                Thread.sleep(2000);

            } catch (InterruptedException e) {

            }

            //如果不是ThreadLocal 当前线程会输出最后一个修改local的值 ，如果同时输出基本上输出时一致的
            System.out.println("ThreadLocal value :" + name);
        }
    }


}