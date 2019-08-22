package com.feiyang.interviewdemo.sortArithmeticDemo;

import java.util.Arrays;

/**
 * @description: 冒泡排序
 * @author: jhyang
 * @create: 2019-05-16 14:14
 **/
public class BubbleSort implements IArraySort {

    @Override
    public int[] sort(int[] sourceArray) throws Exception {

        //复制数组生成新的对象，不影响原数组内容
        int[] arr = Arrays.copyOf(sourceArray, sourceArray.length);

        // 假设每次都会选择一个最大值放在尾部，最大会处理n-1(n为数组长度)
        for (int i = 1; i < arr.length; i++) {
            // 设定一个标记，若为true，则表示此次循环没有进行交换
            boolean flag = true;
            //每次冒泡到最大值后，就少一个元素处理
            // i 要从1开始，交换比实际长度少一个元素
            for (int j = 0; j < arr.length-i; j++) {
                //相邻数据交换位置
                if (arr[j] > arr[j + 1]) {
                    // 临时变量，处理数据位置交换
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    flag = false;
                }
            }
            if (flag) {
                break;
            }
        }

        return arr;
    }
}
