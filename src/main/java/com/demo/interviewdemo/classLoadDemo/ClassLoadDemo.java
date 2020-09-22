package com.demo.interviewdemo.classLoadDemo;

/**
 * @description:
 * 类加载 双亲委托机制
 * @author: jhyang
 * @create: 2019-08-12 18:24
 **/
public class ClassLoadDemo {

    public static void main(String[] args) {
        Class c = ClassLoadDemo.class;

        ClassLoader cl = c.getClassLoader();
    }
}
