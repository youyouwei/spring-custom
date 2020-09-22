package com.demo.interviewdemo.jvmDemo;

import java.lang.ref.WeakReference;

/**
 * @description: 软引用
 * @author: jhyang
 * @create: 2019-04-02 18:27
 **/
public class SoftReferenceDemo {
    public static void main(String[] args) {

//        method2();
        method();
//        System.gc();

    }

    /**
     * 回收软引用
     */
    public static void method() {
        // weak reference是弱引用，当进行垃圾回收时无论内存是否够用都会回收弱引用的内存
        // 这个数组对象需占用内存比较大，直接被分配在老年代中  所以控制台输出GC信息主要是老年代回收
        WeakReference<int[]> softReference = new WeakReference<>(new int[300000000]);
        System.gc();
//        [GC (System.gc())  1177036K->1173149K(1419264K), 0.0019079 secs]
//        [Full GC (System.gc())  1173149K->1097K(1419264K), 0.0159800 secs]
        System.out.println(softReference.get());

        int[] strongReference = new int[100000000];

        System.out.println(softReference.get());
    }

    /**
     * 软引用在GC的时候如果内存不足会进行主动回收，
     */
    public static void method2() {
        System.out.println("===============print GC detail================");

    }
}
