package com.demo.interviewdemo.sortArithmeticDemo;

/**
 * @description:
 * @author: jhyang
 * @create: 2019-05-16 13:51
 **/
public class DemoTest {

    public static void main(String[] args) throws Exception {

        //FizzBuzz.fizzBuzzArithmetic();

        int[] sourceArray = {19,4,7,5,9,11,14,55};

        sort(new BubbleSort().sort(sourceArray));

        sort(new SelectionSort().sort(sourceArray));

        sort(new InsertSort().sort(sourceArray));

    }

    public static void sort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

}
