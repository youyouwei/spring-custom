package com.feiyang.interviewdemo.testdemo;

import com.feiyang.interviewdemo.springcontext.User;

/**
 * @description:
 * @author: jhyang
 * @create: 2019-04-18 13:56
 **/
public class ThreadTest {

    public static void main(String[] args) throws InterruptedException {
        System.out.println("----------thread sleep-----------");

        while (true) {
            Thread.sleep(2 * 1000);
            User user = new User();
        }
    }

}
