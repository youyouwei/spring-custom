package com.feiyang.jike.threadConcurrency;

/**
 * @Description:
 * @Author: jiahuiyang
 * @Date: Created in 10:17 2019/12/10
 */
public class VolitileDemo {
    int x = 0;
    volatile boolean v = false;

    public volatile int i = 0;

    public void writer() {
        x = 42;
        v = true;
    }

    public void reader() {
        if (v == true) {
            //这里x会是多少
            System.out.println(x);
        }
    }

    public void addOne() {
        i++;
    }
}
