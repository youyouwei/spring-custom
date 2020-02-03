package com.feiyang.interviewdemo.ArrayDemo;

import java.util.Arrays;
import java.util.Collections;

/**
 * @Description: 数组遍历
 * @Author: jiahuiyang
 * @Date: Created in 11:55 2019/12/17
 */
public class ArrayTraversal {

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 9, 4, 5, 8};
        // 通过iterator 迭代器
        for (int num : nums) {
            System.out.println(num);
        }

        // 通过数组下标
        for (int i = 0; i < nums.length; i++) {
            System.out.println(nums[i]);
        }

        // 通过集合流处理
        Arrays.stream(nums).forEach(System.out::println);

        // 通过数组转集合
        Arrays.asList(nums).forEach(System.out::println);






    }

}
