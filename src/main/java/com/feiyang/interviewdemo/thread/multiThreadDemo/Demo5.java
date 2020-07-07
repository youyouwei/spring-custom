package com.feiyang.interviewdemo.thread.multiThreadDemo;

/**
 * @description:
 * @author: jhyang
 * @create: 2019-06-21 16:13
 **/
public class Demo5 extends Thread {
    public Demo5(String name) {
        super(name);
    }

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            System.out.println(this.getName() + "已经下载了：" + i + "%");
            try {

                Thread.sleep(100);

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("下载完毕，正在安装更新包！！！");

    }

    public static void main(String[] args) throws InterruptedException {
        Demo5 d = new Demo5("守护线程");

        d.setDaemon(true);
        System.out.println("是守护线程吗？" + d.isDaemon());

        d.start();
        for (int i = 0; i < 100; i++) {
            System.out.println(Thread.currentThread().getName() + ":" + i);
        }

    }
}
