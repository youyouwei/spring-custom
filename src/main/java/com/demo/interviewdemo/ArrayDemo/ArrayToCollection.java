package com.demo.interviewdemo.ArrayDemo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @Description: 数组转集合的几种方式
 * @Author: jiahuiyang
 * @Date: Created in 14:10 2019/12/17
 */
public class ArrayToCollection {

    public static void main(String[] args) {
        String[] str = {"name","sex"};
        // 通过Arrays.asList()转换，并且转换后的list只能查改，不能增删；asList返回的是Arrays一个内部静态类，没有add和remove方法
        List<String> list = Arrays.asList(str);


        // 把Arrays.asList()转为ArrayList对象，能够做增删操作
        list = new ArrayList<>(Arrays.asList(str));

        // 通过Collections.addAll()(最高效)
        List<String> newList = new ArrayList<>();
        Collections.addAll(newList, str);

        // 集合排序的本质也是先转化为数组 然后进行排序
        Collections.sort(list);








    }

}
