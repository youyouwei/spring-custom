package com.demo.interviewdemo.java8Demo.streamDemo;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

/**
 * @description:  Stream 创建  除了Stream 还有 DoubleStream 和 IntStream
 *
 *
 *
 * @author: jhyang
 * @create: 2019-05-17 13:42
 **/
public class CreateStream {

    //数组创建stream
    static Stream<?> gen1() {
        String[] strings = {"1", "2", "a"};
        Arrays.stream(strings);
        Stream<String> stream = Stream.of(strings);
        return stream;
    }

    //通过集合
    static Stream<?> gen2() {
        List<String> strings = Arrays.asList("a", "b", "c");
        Stream<String> stream = strings.stream();
        return stream;
    }

    //通过Stream.generate方法来创建
    //        generate 是让你可以通过任何对象都可以创建stream  不光数组和集合
    static Stream<?> gen3() {
        Stream.generate(() -> {
            return Arrays.asList(1, 2, 3);
        });

        Stream.generate(() -> Arrays.asList(1, 2, 3));

        Stream<Object> generate = Stream.generate(Object::new);




        return null;
    }

    public static void main(String[] args) {

        System.out.println(Arrays.asList(1, 2, 3).stream().reduce(10, (x, y) -> x + y));
        // 16   identity是基数 然后进行累加  也可以不加这个参数 或则默认是0 防止累加数据没有值







    }




}
