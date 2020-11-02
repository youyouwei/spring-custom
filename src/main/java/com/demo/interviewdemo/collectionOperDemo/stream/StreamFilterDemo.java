package com.demo.interviewdemo.collectionOperDemo.stream;

import lombok.Data;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @Description:
 * @Author: jiahuiyang
 * @Date: Created in 10:11 2020/11/2
 */
public class StreamFilterDemo {


    public static void main(String[] args) {

        removeElement();

//        method();

    }


    public static void removeElement() {
        List<String> list = new ArrayList<>();
        list.add("111");
        list.add("222");
        list.add("333");
        list.add("444");
        list.add("555");

//        removeListError(list);



        List<String> newList = new ArrayList<>();
        newList.add("tom");
        newList.add("tim");
        newList.add("jim");


        newList.stream().forEach(x -> {
            if (x.equals("tom")) {
                removeListError(list);

                list.forEach(System.out::println);

            }
        });

        list.forEach(System.out::println);
    }


    /**
     * 正例 是使用Iterator 进行遍历并remove处理
     * @param list
     */
    public static void removeList(List<String> list) {
        Iterator iterator = list.iterator();
        while (iterator.hasNext()) {
            if (iterator.next().equals("333")) {
                iterator.remove();
            }
        }
    }

    /**
     * 反例 这种过滤会改变list的引用地址，所以外层调用不能再lambda表达式中，因为lambda 表达式中的集合对象会通过值传递进行处理，会造成没有改变原入参的问题
     *
     * 如果外层调用非lambda表达式不影响
     *
     *
     *
     *
     * Lambda其实是一个匿名函数，在匿名函数里的变量引用，也叫做变量引用泄露，会导致线程安全问题，因此在Java8之前，如果在匿名类内部引用函数局部变量，必须将其声明为final，即不可变对象。
     *
     * Java8这里加了一个语法糖：在lambda表达式以及匿名类内部，如果引用某局部变量，则直接将其视为final。所以不能修改引用值。
     *
     * 这个地方应该实现一个闭包的语义，编译器需要把闭包的对象引用传给内部类。但java实现时没有传引用，而是直接copy了数据。也就是里外两个变量实际上是两个名字和值相同，但各自独立的东西。如果该数据在内部类的函数里可以修改，就会出现里外不一致，于是会露馅。因此java干脆规定这种变量必须是final的，不能改。编辑于 2019-12-23
     *
     */
    public static void removeListError(List<String> list) {

//        list = list.stream().filter(u -> !u.equals("333")).collect(Collectors.toList());


        list = new ArrayList<>();
    }


    @Data
    static class User {

        private Integer id;

        private String name;
    }


    public static void method() {
        User user = new User();
        user.setId(1);
        user.setName("tom");


        modify(user);

        System.out.println(user);

    }

    /**
     * Java 中的方法参数都是按值传递的：基本数据类型 按值传递（拷贝的基本类型的值），对象引用 按值传递（拷贝的引用）
     * @param user
     */
    private static void modify(User user) {

        //对 引用对象直接修改引用地址 并不会改变外层引用的地址，但是如果你修改引用对象中内容则会影响外层引用对象的内容
        //所以java方法的参数传递本身都是值传递，只不过如果是引用对象值传递复制过去的是引用地址，修改同一个引用地址中的内容会互相影响外层调用的相同引用地址中内容
        user = new User();
        System.out.println(user);
    }


}


