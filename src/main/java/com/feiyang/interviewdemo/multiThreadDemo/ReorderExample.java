package com.feiyang.interviewdemo.multiThreadDemo;

/**
 * @description:
 * @author: jhyang
 * @create: 2019-06-25 14:02
 **/
public class ReorderExample {

    int a = 0;
    boolean flag = false;

    public void writer() {
        a = 1;
        flag = true;
    }

    public void reader() {
        if (flag) {
            int i = a * a;
        }
    }

}
