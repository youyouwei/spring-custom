package com.demo.interviewdemo.thread;

import java.util.Date;

/**
 * @Description:
 * @Author: jiahuiyang
 * @Date: Created in 14:12 2020/8/2
 */
public class ThreadDemo {

    public static void main(String[] args) {
        method();
    }

    public static void method() {
        new Thread(()->{
            while (true) {
                System.out.println(new Date());
            }
        }).start();
    }

}
