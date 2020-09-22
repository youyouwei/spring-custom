package com.demo.interviewdemo.sortArithmeticDemo;

import java.util.Arrays;

/**
 * @description: 插入排序
 * @author: jhyang
 * @create: 2019-05-16 15:22
 **/
public class InsertSort implements IArraySort {
    @Override
    public int[] sort(int[] sourceArray) throws Exception {
        int[] arr = Arrays.copyOf(sourceArray, sourceArray.length);

        for (int i = 1; i < arr.length; i++) {
            //取每轮的第一个
            int tmp = arr[i];
            int j = i;
            while (j > 0 && tmp < arr[j - 1]) {
                arr[j] = arr[j - 1];
                j--;
            }
            if (j != i) {
                arr[j] = tmp;
            }
        }
        return arr;
    }
}
