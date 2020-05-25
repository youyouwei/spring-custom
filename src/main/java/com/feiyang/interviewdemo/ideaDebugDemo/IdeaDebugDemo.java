package com.feiyang.interviewdemo.ideaDebugDemo;

import java.util.Arrays;
import java.util.List;

/**
 * @Description: idea 调试技巧
 * idea设置断点进入debug模式，在debug窗口会出现，debug窗口会有调试按钮
 * 其中可以右键文件通过watches来查看变量的值；还可以通过evaluate 来计算表达式的值
 *
 * 断点条件可以通过右键来添加debug调试条件，其中断点条件中的condition表达式返回值需要是Boolean类型，并且设置断点条件需要使用已经定义过的变量，不要在变量定义处设置该变量的条件断点，不然执行过程会出现找不到该变量，正常会先判断条件断点的条件表达式返回值是否为true，在进入断点执行当前行
 * 然后自定义表达式（返回为boolean的表达式）
 * 如：在println处设置条件断点，表达式为i==1，debug执行的过程中如果表达式返回为true就可以进入断点，否则不进入断点直接执行
 * 断点条件可以再循环遍历过程中调试自己预期的某个值的执行过程，或则在程序执行过程中出现某个预期值时进行调试
 *
 *
 * @Author: jiahuiyang
 * @Date: Created in 10:46 2020/5/25
 */
public class IdeaDebugDemo {
    public static void main(String[] args) {
//        int id = 1;
//
//        System.out.println("hello");

        method();

    }

    public static void method() {
        List<Integer> list = Arrays.asList(1, 24, 2, 55, 634);
        for (Integer integer : list) {
            System.out.println(integer);
        }
    }



}
