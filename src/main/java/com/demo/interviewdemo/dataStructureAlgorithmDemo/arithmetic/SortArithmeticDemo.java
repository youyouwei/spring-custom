package com.demo.interviewdemo.dataStructureAlgorithmDemo.arithmetic;

/**
 * @Description:
 * @Author: jiahuiyang
 * @Date: Created in 18:10 2020/9/6
 */
public class SortArithmeticDemo {


    /**
     * 快速排序 O(NlogN)
     */
    static class QuickSort {
        public static void quickSort(int[] array, int left, int right) {
            int key = array[left];
            int start = left;
            int end = right;
            while (start < end) {
                //从后往前
                while (array[end] > key && start < end) {
                    end--;
                }
                if (array[end] < key) {
                    int temp = array[end];
                    array[end] = array[start];
                    array[start] = temp;
                }
                //从前往后
                while (array[start] < key && start < end) {
                    start++;
                }
                if (array[start] > key) {
                    int temp = array[end];
                    array[end] = array[start];
                    array[start] = temp;
                }
            }

            if (start > left) {
                quickSort(array, left, start - 1);
            }
            if (end < right) {
                quickSort(array, end + 1, right);
            }
        }

        public static void main(String[] args) {
            int[] a = {7,6,5,4,3,2,1};
            quickSort(a, 0, a.length - 1);
            for (int m = 0; m < a.length; m++) {
                System.out.println(a[m]);
            }
        }
    }

    /**
     * 冒泡排序
     */
    static class BubbleSort {
        public static void bubbleSort(int[] arr) {
            if(arr == null || arr.length == 0)
                return ;
            for(int i = 0; i < arr.length - 1; i ++) {
                for(int j = 0; j < arr.length - 1 - i; j ++) {
                    if(arr[j] > arr[j + 1]) {
                        swap(arr, j, j + 1);
                    }
                }
            }
        }


        public static void swap(int[] arr, int i, int j) {
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }

        public static void main(String[] args) {
            int[] a = {7,6,5,4,3,2,1};
            bubbleSort(a);
            for (int m = 0; m < a.length; m++) {
                System.out.println(a[m]);
            }
        }
    }

    /**
     * 二分查找法排序
     */
    static class BinarySearch {
        public static int binarySearch(int data[], int target) {
            if (data == null || data.length == 0) {
                return -1;
            }
            int low = 0;
            int high = data.length - 1;
            //<=包含等于是可能有这种情况 小标为3和4 mid=3，但是3<key(4),l++=h 这个时候如果不能等于则会丢失可能找不到
            while(low <= high) {
                int middle = (low + high) / 2;
                if (data[middle] == target) {
                    return middle;
                }
                if (data[middle] < target) {
                    high = middle - 1;
                }
                if (data[middle] > target) {
                    low = middle + 1;
                }
            }
            return -1;
        }

        public static void main(String[] args) {
            int[] a = {7,6,5,4,3,2,1};
            int result = binarySearch(a, 3);
            System.out.println(result);
        }
    }






}
