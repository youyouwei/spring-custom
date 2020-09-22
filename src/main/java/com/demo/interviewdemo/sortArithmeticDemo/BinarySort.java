package com.demo.interviewdemo.sortArithmeticDemo;

/**
 * @description: 二分法排序
 * @author: jhyang
 * @create: 2019-07-19 10:20
 **/
public class BinarySort {

    public static int binarySearch(int[] a, int destElement) {
        //元素首索引
        int begin = 0;
        //元素尾索引
        int end = a.length - 1;
        while (begin <= end) {
            //计算折半下标 (先加后除 注意运算符优先级)
            int mid = (begin + end) / 2;
            //判断是否折半值和目标值的大小
            if (a[mid] == destElement) {
                return mid;
            } else if (a[mid] > destElement) {
                //找小的半边
                end = mid - 1;
            } else if (a[mid] < destElement) {
                //找大的半边
                begin = mid + 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] a = {1,3,4,5,7,8,9,10,23,25,29};
        int destElement = 5;
        //int index = binarySearch(a, destElement);
        int index = binarySearch2(a, destElement);
        System.out.println((index == -1) ? destElement + "元素不存在！" : destElement + "在数组中的下标是：" + index);
    }

    public static int binarySearch2(int[] a, int destElement) {
        int max, min, mid;
        min = 0;
        max = a.length;
        mid = (min + max) / 2;
        while (a[mid] != destElement) {
            if (destElement > a[mid]) {
                min = mid + 1;
            } else if (destElement < a[mid]) {
                max = mid - 1;
            }
            if (max < min) {
                return -1;
            }
            mid = (max + min) / 2;
        }
        return mid;
    }



}
