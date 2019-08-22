package com.feiyang.interviewdemo.jvmDemo;

import java.lang.ref.SoftReference;

/**
 * @description: 软引用
 * @author: jhyang
 * @create: 2019-04-02 18:27
 **/
public class SoftReferenceDemo {
    public static void main(String[] args) {
        SoftReference<int[]> softReference = new SoftReference<>(new int[300000000]);

        System.gc();
        System.out.println(softReference.get());

        int[] strongReference = new int[100000000];

        System.out.println(softReference.get());

    }
}
