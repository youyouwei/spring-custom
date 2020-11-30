package com.demo.interviewdemo.java8Demo.optionalDemo;

import com.google.common.collect.Lists;
import com.google.common.collect.Streams;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;

import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @Description:
 * @Author: jiahuiyang
 * @Date: Created in 15:29 2020/11/26
 */
public class OptionalDemo<T> {

    public static void main(String[] args) {
        List<String> list = Lists.newArrayList();
        list.add("1");
        list.add("2");
        list.add("3");

        //直接遍历全部输出或则处理元素
        if (CollectionUtils.isNotEmpty(list)) {
            for (String s : list) {
                System.out.println(s);
            }
        }

        Optional.ofNullable(list).ifPresent(System.out::print);


        //list 集合转换
        List<Integer> integerList = Lists.newArrayList();
        if (CollectionUtils.isNotEmpty(list)) {
            for (String s : list) {
                if (StringUtils.isNotBlank(s)) {
                    int i = Integer.valueOf(s);
                    integerList.add(i * 2);
                }

            }
        }

        integerList = Optional.ofNullable(list)
                .map(x -> Lists.transform(x, Integer::valueOf))
                .orElseGet(Lists::newArrayList);


        //查找某个元素 并返回
        Integer result = 0;
        if (CollectionUtils.isNotEmpty(list)) {
            for (String s : list) {
                if ("1".equals(s)) {
                    result = Integer.valueOf(s);
                }
            }
        }


        result = Optional.ofNullable(list)
                .orElseGet(Lists::newArrayList)
                .stream()
                .filter(Predicate.isEqual("1"))
                .map(Integer::valueOf)
                .findFirst()
                .orElseGet(null);

        // 或则

        result = Optional.ofNullable(list)
                .map(OptionalDemo::cal)
                .orElse(null);


        // optional转stream
        // 注 在 java 9 中可以直接Optional to Stream转换  如Optional.ofNullable(list).stream()，这样对集合的操作就更加方便。

        result = Optional.ofNullable(list).map(List::stream)
                .orElseGet(Stream::empty)
                .filter(Predicate.isEqual("1"))
                .map(Integer::valueOf)
                .findFirst()
                .orElse(null);


        List<String> list1 = null;

        OptionalDemo.method(list1);


        //使用guava三方库工具 Optional to Stream
        Streams.stream(Optional.ofNullable(list)).collect(Collectors.toList());




    }

    private static void method(List<String> list1) {
        // 注 这种直接get很危险 容易报错要通过map 进行转换处理 或则orElseGet
        Optional.ofNullable(list1).get()
                .stream()
                .findFirst();
    }

    //或则在map转换中抽象出来方法 如果为空不会走map 所以不用加if非空判断
    private static Integer cal(List<String> list) {
        return list.stream()
                .filter(Predicate.isEqual("1"))
                .map(Integer::valueOf)
                .findFirst()
                .orElseGet(null);
    }


}
