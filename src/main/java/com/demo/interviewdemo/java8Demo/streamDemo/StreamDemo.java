package com.demo.interviewdemo.java8Demo.streamDemo;

import org.springframework.util.Assert;
import org.springframework.util.StringUtils;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @description: 集合stream操作
 * @author: jhyang
 * @create: 2019-07-23 16:34
 **/
public class StreamDemo {

    private String name = "";

    public static void main(String[] args) {


        reduceMethod();
    }

    /**
     * toMap使用方法
     */
    public static void toMap() {

    }

    /**
     * map转list
     */
    public static void mapToList() {



    }

    /**
     * list转map
     */
    public static void listToMap() {

    }

    /**
     * 元素合并操作
     * stream api的reduce方法用于对stream中元素进行聚合求值，最常见的用法就是将stream中一连串的值合成为单个值，比如为一个包含一系列数值的数组求和。
     */
    public static void reduceMethod() {

        List<Integer> numList = Arrays.asList(1, 2, 3, 4, 5);
        //累加求和
        //lambada表达式的a参数是表达式的执行结果的缓存，也就是表达式这一次的执行结果会被作为下一次执行的参数，
        // 而第二个参数b则是依次为stream中每个元素。如果表达式是第一次被执行，a则是stream中的第一个元素。
        int result = numList.stream().reduce((a, b) -> a + b).get();
        System.out.println(result);

        //如果为空返回第一个参数默认值
        result = numList.stream().reduce(0, (a, b) -> a + b);
        System.out.println(result);
        //第三个参数表示 类型转换 int->long
        long resultNew = numList.stream().reduce(0L, (a, b) -> a + b, (a, b) -> 0L);
        System.out.println(resultNew);

    }

    public static void method() {
        List<String> list = Arrays.asList("a", "b", "c", "c");
        //toList
        List<String> listNew = list.stream().map(String::toUpperCase).collect(Collectors.toList());
        System.out.println(listNew);
        // toMap 第三个参数是key重复处理方式
        Map<String, String> map = list.stream().map(String::toUpperCase).collect(Collectors.toMap(String::toString, String::toString, (oldValue, newValue) -> oldValue, HashMap::new));
        System.out.println(map);
    }

    /**
     * 基本类数组转包装类
     */
    public static void method1() {
        int[] nums = {1, 3, 6, 4};
//        Integer[] integers = Arrays. ;
        Assert.notNull(null, null);



    }


    /**
     * java8 stream 中map 和 reduce操作
     * map是映射函数 可以把入参转成另外一个类型
     * reduce 是执行一个函数
     */
    public static void mapReduce() {




    }



}
