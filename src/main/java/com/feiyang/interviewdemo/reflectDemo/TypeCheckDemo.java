package com.feiyang.interviewdemo.reflectDemo;

/**
 * @description: 类型检查
 * @author: jhyang
 * @create: 2019-07-04 20:49
 **/
public class TypeCheckDemo {

    public static void main(String[] args) {
        Object object = new TypeCheckDemo();
        Class clazz = object.getClass();
        System.out.println(clazz.getName());

    }

}
