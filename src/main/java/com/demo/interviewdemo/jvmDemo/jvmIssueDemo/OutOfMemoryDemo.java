package com.demo.interviewdemo.jvmDemo.jvmIssueDemo;

import java.util.ArrayList;
import java.util.List;

/**
 * @description: 内存溢出实例
 * 可以通过设置 -Xmx50m -Xms50m (堆内存最大值和内存初始值)
 * @author: jhyang
 * @create: 2019-07-04 11:09
 **/
public class OutOfMemoryDemo {

    public static List<Tree> list = new ArrayList<>();

    private static int stackLength = 0;

    private static int oomNum = 0;

    public static void main(String[] args) {

        //oom
        try {
            oomMe();
        } catch (Throwable e) {
            System.out.println("oom number:" + oomNum);
            throw e;
        }

        //stack over flow
        /*try {
            stackOverFlowMe();

        } catch (Throwable e) {
            System.out.println("stack length:" + stackLength);
            throw e;
        }*/
    }

    /**
     * 创建过多强引用对象
     */
    public static void oomMe() {

        List<Tree> newList = new ArrayList<>();

        for (;;) {
            Tree tree = new Tree();
            newList.add(tree);
            oomNum++;
        }

        //System.out.println("创建完成");

    }

    public static void stackOverFlowMe() {

        stackLength++;
        stackOverFlowMe();

    }

    static class Tree {
        //如果不加数组增加内存消耗 需要创建耗时较长才能爆出oom

        private int[] ints = new int[1000000];

        private String name;
    }

}
