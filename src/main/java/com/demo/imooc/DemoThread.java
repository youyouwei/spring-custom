package com.demo.imooc;

import java.util.concurrent.TimeUnit;

/**
 * @Description:
 * @Author: jiahuiyang
 * @Date: Created in 9:42 2020/11/2
 */
public class DemoThread extends Thread {

    public DemoThread() {

    }

    @Override
    public void run() {
        for (int i = 0; i < 4; i++) {
            System.out.println(Thread.currentThread().getName() + "-->" + i);

            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {

            }
        }
    }
}
