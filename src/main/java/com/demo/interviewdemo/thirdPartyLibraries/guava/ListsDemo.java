package com.demo.interviewdemo.thirdPartyLibraries.guava;

import com.google.common.collect.Lists;

import java.util.List;

/**
 * @Description: guava Lists 工具类
 * @Author: jiahuiyang
 * @Date: Created in 17:18 2020/11/25
 */
public class ListsDemo {

    public static void main(String[] args) {

    }

    public void method() {
        //创建集合 使用工厂方法
        List<String> list = Lists.newArrayList();
        list.add("1");
        list.add("2");
        list.add("3");
        //集合转换 泛型类型转换
        List<Integer> integerList = Lists.transform(list, Integer::valueOf);
    }

}
