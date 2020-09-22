package com.demo.interviewdemo.dynamicproxy;

/**
 * @description: 原类
 * @author: jhyang
 * @create: 2019-04-04 09:40
 **/
public class BeautyWang implements Girl {
    @Override
    public void eat() {
        System.out.println("一起吃饭");
    }

    @Override
    public void watchMovie() {
        System.out.println("一起看电影");
    }
}
