package com.feiyang.interviewdemo.java8Demo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @Description: 模拟实现Map 和 Reduce功能
 * @Author: jiahuiyang
 * @Date: Created in 15:17 2020/5/20
 */
public class MapReduceDemo {

    public static void main(String[] args) {
//        testMap();

//        testReduce();
        method();

    }

    /**
     * 测试map函数方法
     * map是把元数据结构映射成目标数据结构 也可以对目标数据结构进行处理
     * 如：把自定义类对象映射成某一个基本类型的集合
     */
    public static void testMap() {
        List<Library> nums = new ArrayList<>();
        for (int i = 1; i <= 10; i++) {
            nums.add(new Library(Long.valueOf(i), "bookType" + i, "bookName" + i));
        }

        //把链表中的元素乘以10后转换成string
//        System.out.println(MyMap.map(e -> String.valueOf(e * 10) + ";", nums));

        List<Long> bookIds = nums.stream().map(Library::getId).collect(Collectors.toList());

    }

    public static void testReduce() {
        List<Library> nums = new ArrayList<>();
        for (int i = 1; i <= 10; i++) {
            nums.add(new Library(Long.valueOf(i), "bookType" + i, "bookName" + i));
        }
        String appendBooks = nums.stream().map(Library::getBookName).reduce((u, v) -> u + "," + v).orElse("");
        System.out.println(appendBooks);
    }

    public static void method() {
        int capacity = 10000;
        List<String> list = new ArrayList<>(capacity);
        for (int i = 0; i < capacity; i++) {
            list.add("name" + i);
        }
        long start = System.currentTimeMillis();
        System.out.println(list.stream().reduce((u, v) -> u + "," + v).orElse(""));
        System.out.println("consume time = " + (System.currentTimeMillis() - start));

       /* start = System.currentTimeMillis();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < capacity; i++) {
            sb.append(list.get(i) + ",");
        }
        System.out.println(sb.toString().substring(0, sb.length() - 1));
        System.out.println("consume time = " + (System.currentTimeMillis() - start));*/

        start = System.currentTimeMillis();
        String names = "";
        for (int i = 0; i < capacity; i++) {
            names += list.get(i) + ",";
        }
        System.out.println(names.substring(0, names.length() - 1));
        System.out.println("consume time = " + (System.currentTimeMillis() - start));

    }

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    static class Library {
        private Long id;
        private String bookType;
        private String bookName;
    }

}


