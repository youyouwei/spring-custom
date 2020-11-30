package com.demo.interviewdemo.sourceCodeDemo;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Description: ArrayList 源码
 * @Author: jiahuiyang
 * @Date: Created in 17:29 2020/11/17
 */
public class ArrayListSourceCode {

    public static void main(String[] args) throws IOException {

        //初始化 ArrayList如果不传容积大小，就默认是空数组，并且在add时进行第一次扩容为默认容积大小10
        List<String> list = Arrays.asList("tom");
        Object[] objects = list.toArray();

        objects[0] = "jack";

        System.in.read();


    }
}
