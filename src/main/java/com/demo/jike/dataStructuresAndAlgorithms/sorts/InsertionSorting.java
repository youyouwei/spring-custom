package com.demo.jike.dataStructuresAndAlgorithms.sorts;

import java.util.Arrays;

/**
 * @Description: 插入排序 (从前两个开始 通过相邻比较交换位置 得到前几个的有序排序结果)
 * @Author: jiahuiyang
 * @Date: Created in 11:28 2019/12/17
 */
public class InsertionSorting {
    public static void main(String[] args) {
        sort();

    }

    public static void sort() {

        int[] nums = {1, 2, 4, 9, 5, 3, 13, 44, 23};

        for (int i = 1; i < nums.length; i++) {
            for (int j = i; j > 0; j--) {
                if (nums[j] < nums[j - 1]) {
                    int temp = nums[j];
                    nums[j] = nums[j - 1];
                    nums[j - 1] = temp;
                }

            }
        }

//        System.out.println(nums);
        Arrays.stream(nums).forEach(System.out::println);



    }

}
