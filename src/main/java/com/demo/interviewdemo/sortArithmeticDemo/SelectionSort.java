package com.demo.interviewdemo.sortArithmeticDemo;

import java.util.Arrays;

/**
 * @description:  选择排序
 * @author: jhyang
 * @create: 2019-05-16 15:05
 **/
public class SelectionSort implements IArraySort {
    @Override
    public int[] sort(int[] sourceArray) throws Exception {
        int[] arr = Arrays.copyOf(sourceArray, sourceArray.length);

        // 经过 N-1 轮比较  每轮选择最小元素和 每轮的最开始位置交换
        for (int i = 0; i < arr.length-1; i++) {
            int min = i;
            //每轮需要比较的次数 N-i
            for (int j = i+1; j < arr.length; j++) {
                //每次选出最小元素的下标
                if (arr[j] < arr[min]) {
                    min = j;
                }

            }

            if (i != min) {
                int temp = arr[i];
                arr[i] = arr[min];
                arr[min] = temp;
            }
        }

        return arr;
    }
}
