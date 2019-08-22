package com.feiyang.interviewdemo.streamDemo;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

/**
 * @description:
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
    static Stream<?> gen3() {
        return null;
    }




}
