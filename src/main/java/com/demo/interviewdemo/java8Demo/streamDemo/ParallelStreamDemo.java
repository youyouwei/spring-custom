package com.demo.interviewdemo.java8Demo.streamDemo;

import com.google.common.base.Stopwatch;
import com.google.common.collect.Lists;

import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * @Description: parallel stream 并发 流处理
 * @Author: jiahuiyang
 * @Date: Created in 22:46 2020/11/25
 */
public class ParallelStreamDemo {

    public static void main(String[] args) {
        parallel();
    }

    public static void parallel() {


        IntStream.of(1, 2, 3).parallel().mapToObj(x -> x << 1).forEach(System.out::println);


        List<String> list = Lists.newArrayList();

//        list.parallelStream()


        List<Integer> integerList = Lists.newArrayListWithCapacity(10000);

        for (int i = 0; i < integerList.size(); i++) {
            integerList.add(1);
        }

        Integer sum = 0;

        Stopwatch stopwatch = Stopwatch.createStarted();


        //函数方法 一般不能传可变的外部变量 避免
//        integerList.parallelStream().forEach(x -> sum.);



    }




}
