package com.demo.interviewdemo.thread.multiThreadDemo;

import java.util.concurrent.ConcurrentHashMap;

/**
 * @description:
 * @author: jhyang
 * @create: 2019-06-30 21:56
 **/
public class ConcurrentHashMapDemo {
    public static void main(String[] args) {
        ConcurrentHashMap<String, String> map = new ConcurrentHashMap<>(1 << 4);

        System.out.println(1 << 4);

    }
}
