package com.demo.interviewdemo.basicOperateDemo;

/**
 * @Description: 跳出If代码块
 * @Author: jiahuiyang
 * @Date: Created in 15:09 2020/6/12
 */
public class IfBreakDemo {
    public static void main(String[] args) {
        method();
    }

    /**
     * 跳出If代码块
     */
    public static void method() {
        int i = 0;
        out:if (i < 10) {
            System.out.println(0);
            //实际操作应该是每次处理都会不一样 如果每次处理一样可以使用do while来处理循环判断
            i+=5;
            if (i >= 10) {
                break out;
            }
            System.out.println(1);
            i+=5;
            if (i >= 10) {
                break out;
            }
            System.out.println(2);
            i+=5;
            if (i >= 10) {
                break out;
            }
            System.out.println(3);

        }

    }
}
