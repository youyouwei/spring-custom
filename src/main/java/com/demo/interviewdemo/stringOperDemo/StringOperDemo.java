package com.demo.interviewdemo.stringOperDemo;

/**
 * @description: 字符串操作
 * @author: jhyang
 * @create: 2019-07-04 11:00
 **/
public class StringOperDemo {
    public static void main(String[] args) {

        String s = new String("string");
        String s1 = "string";
        System.out.println(s == s1);
        System.out.println(s.equals(s1));

        switch (s) {
            case "string":
                System.out.println("string");
                break;
            default:
                System.out.println("no string");
        }

    }


}
