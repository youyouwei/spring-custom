package com.feiyang.interviewdemo.buildDemo;

import com.alibaba.fastjson.JSON;

import java.math.BigDecimal;

/**
 * @Description:
 * @Author: jiahuiyang
 * @Date: Created in 18:13 2019/11/13
 */
public class BuildDemo {

    public static void main(String[] args) {

        Book book = new Book.Builder().name("tom").price(BigDecimal.valueOf(1)).publisher("china").build();

        System.out.println(JSON.toJSONString(book));

        Book newBook = new Book();
        System.out.println(JSON.toJSONString(newBook));

    }



}

