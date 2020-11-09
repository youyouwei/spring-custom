package com.demo.interviewdemo.concurrentDemo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @Description:
 * @Author: jiahuiyang
 * @Date: Created in 21:58 2020/11/7
 */
public class Demo {

    private static final Logger LOGGER = LoggerFactory.getLogger(Demo.class);

    public static void main(String[] args) {
        String str = "a,b,c,1,,,,,";

        String[] ary = str.split(",");
        System.out.println(ary.length);


        LOGGER.info("log info ...");

    }
}
