package com.demo.interviewdemo.jsonDemo;

import com.alibaba.fastjson.JSON;

/**
 * @Description:
 * @Author: jiahuiyang
 * @Date: Created in 14:26 2020/9/25
 */
public class Array2JsonDemo {

    public static void main(String[] args) {
        method();
    }


    public static void method() {
        Integer[] integers = {1,2,3};

        System.out.println(JSON.toJSONString(integers));

    }

}
