package com.feiyang.interviewdemo.jvmDemo;

import com.sun.nio.zipfs.ZipInfo;
import jdk.nashorn.internal.runtime.linker.Bootstrap;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @description: class load 类加载器
 * @author: jhyang
 * @create: 2019-07-24 15:25
 **/
public class ClassLoadDemo {

    public static void main(String[] args) throws ClassNotFoundException {
        String s = "";
        System.out.println(s.getClass().getClassLoader());

        ClassLoadDemo classLoadDemo = new ClassLoadDemo();
        System.out.println(classLoadDemo.getClass().getClassLoader());

        ClassLoader classLoader = classLoadDemo.getClass().getClassLoader();
        while (classLoader != null) {
            System.out.print(classLoader.getClass().getName() + "->");
            //获取该加载器的父类加载器  null代表他的父加载器是 根加载器
            classLoader = classLoader.getParent();
        }
        System.out.print(classLoader);

        //jdk系统提供的类 rt中 都是使用根加载器 由于BootStrap根加载器不是Java编写 所以打印出来是null
        System.out.println(List.class.getClassLoader());

        //在jre/lib/ext 中的jar 都是扩展类加载器加载
        System.out.println(ZipInfo.class.getClassLoader());

        //Class c = classLoader.loadClass("com.feiyang.interviewdemo.jvmDemo.ClassLoadDemo");

        System.out.println();


        AtomicInteger atomicInteger = new AtomicInteger();






    }

}
