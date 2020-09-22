package com.demo.jike.dataStructuresAndAlgorithms.sorts;

/**
 * @Description: 快速排序
 * @Author: jiahuiyang
 * @Date: Created in 15:38 2019/12/17
 */
public class QuickSort {
    public static void main(String[] args) {

    }


    /**
     * 递归处理
     * @param nums
     * @param start
     * @param end
     */
    public static void recursionPart(int[] nums, int start, int end) {
        if (end - start < 1) {
            return;
        }

        int partN = part(nums, start, end);

        //TODO 待分析
        if (partN == start) {
            recursionPart(nums, partN + 1, end);
        } else if (partN == start) {
            recursionPart(nums, start, end - 1);
        } else {
            recursionPart(nums, start, partN - 1);
            recursionPart(nums, partN + 1, end);
        }
    }

    /**
     * 一次基准值划分
     * @param nums
     * @param start
     * @param end
     * @return
     */
    public static int part(int[] nums, int start, int end) {

        //比较的基准值
        int base = nums[end];
        // 切换的位置
        int n = start;
        for (int i = start; i < end; i++) {
            //如果小于基准值并且切换的位置不是当前元素索引位置，进行位置交换
            if (nums[i] < base) {
                if (i != n) {
                    exchangeIndex(nums, i, n);
                }
                n++;
            }

        }
        //第一次遍历后 将基准值放到n处，此时小于基准值的都在基准值的左边，大于基准值的都在基准值的右边
        exchangeIndex(nums, n, end);

        return n;

    }

    /**
     * 位置交换
     * @param nums
     * @param i1
     * @param i2
     */
    public static void exchangeIndex(int[] nums, int i1, int i2) {
        int temp = nums[i1];
        nums[i2] = nums[i1];
        nums[i1] = temp;
    }


}
