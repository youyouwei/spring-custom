package com.demo.interviewdemo.sortArithmeticDemo;

/**
 * @description:
 * @author: jhyang
 * @create: 2019-05-16 13:50
 **/
public class FizzBuzz {

    public static void fizzBuzzArithmetic() {
        for (int i = 0; i < 100; i++) {
            int num = i + 1;
            if (num % 3 == 0 && num % 5 == 0) {
                System.out.println("FizzBuzz--"+num);
            } else if (num % 3 == 0 && num % 5 != 0) {
                System.out.println("Fizz--"+num);
            } else if (num % 3 != 0 && num % 5 == 0) {
                System.out.println("Buzz--"+num);
            } else {
                System.out.println("Nothing--"+num);
            }
        }
    }


}
