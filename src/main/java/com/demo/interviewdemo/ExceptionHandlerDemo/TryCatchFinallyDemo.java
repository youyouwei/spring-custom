package com.demo.interviewdemo.ExceptionHandlerDemo;

/**
 * @Description:
 * @Author: jiahuiyang
 * @Date: Created in 10:20 2020/3/23
 */
public class TryCatchFinallyDemo {
    public static void main(String[] args) {

    }

    /**
     * finally 执行
     */
    public static void method() {
        try {
            int[] nums = new int[1];
            System.out.println(nums[1]);

        } catch (IndexOutOfBoundsException e) {
            return;

        }finally {
//            会先执行finally中代码然后再执行catch中的return 如果finally中有return会覆盖catch中的return
            System.out.println("execute finally code");
            return;

        }

    }
}
