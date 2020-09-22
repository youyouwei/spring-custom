package com.demo.interviewdemo.jvmDemo;

import java.lang.ref.WeakReference;

/**
 * @description: 弱引用
 * @author: jhyang
 * @create: 2019-04-02 20:26
 **/
public class WeakReferenceDemo {

    @SuppressWarnings("unused")
    public static void main(String[] args) {

        String s = "";

        WeakReference<String[]> weakReference = new WeakReference<>(new String[1000]);

        System.out.println(weakReference.get());

        System.gc();

        System.out.println(weakReference.get());
    }

}

