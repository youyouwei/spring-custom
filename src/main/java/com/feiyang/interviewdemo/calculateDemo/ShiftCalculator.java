package com.feiyang.interviewdemo.calculateDemo;

/**
 * @description: 移位运算 针对二进制移位（先把当前数据转换成二进制，然后进行移位）
 * @author: jhyang
 * @create: 2019-06-24 11:41
 **/
public class ShiftCalculator {
    private static final int counter = 1 << 7;   //左移

    public static void main(String[] args) {
        System.out.println("左移运算---");
        System.out.println("1 左移7位 应为128：" + counter);
    }
}
