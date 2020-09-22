package com.demo.interviewdemo.ArrayDemo;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * @Description:
 * @Author: jiahuiyang
 * @Date: Created in 17:15 2019/11/20
 */
public class ArrayInitialDemo {
    public static void main(String[] args) {

        // 使用{}初始化空数组 后续需要继续
        Object[] objects = {};
        objects[0] = 1;

        // 初始化固定长度数组
        String[] strings = new String[10];

        System.out.println(objects[0]);
    }


}
