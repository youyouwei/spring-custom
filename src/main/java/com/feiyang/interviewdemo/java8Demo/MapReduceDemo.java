package com.feiyang.interviewdemo.java8Demo;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description: 模拟实现Map 和 Reduce功能
 * @Author: jiahuiyang
 * @Date: Created in 15:17 2020/5/20
 */
public class MapReduceDemo {

    public static void main(String[] args) {
        testMap();
    }

    /**
     * 测试map函数方法
     */
    public static void testMap() {
        List<Integer> nums = new ArrayList<>();
        for (int i = 1; i <= 10; i++) {
            nums.add(i);
        }

        //把链表中的元素乘以10后转换成string
        System.out.println(MyMap.map(e -> String.valueOf(e * 10) + ";", nums));

    }

    public static void testReduce() {
        List<Integer> nums = new ArrayList<>();
        List<String> strs = new ArrayList<>();
    }

}


