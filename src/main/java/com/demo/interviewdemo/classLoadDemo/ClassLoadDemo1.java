package com.demo.interviewdemo.classLoadDemo;

import com.sun.nio.zipfs.ZipInfo;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @description: class load 类加载器
 * @author: jhyang
 * @create: 2019-07-24 15:25
 **/
public class ClassLoadDemo1 {

    public static void main(String[] args) throws ClassNotFoundException {
        String s = "";
        System.out.println(s.getClass().getClassLoader());

        ClassLoadDemo1 classLoadDemo = new ClassLoadDemo1();
        System.out.println(classLoadDemo.getClass());
        System.out.println(classLoadDemo);

        System.out.println(classLoadDemo.getClass().getClassLoader());

        ClassLoader classLoader = classLoadDemo.getClass().getClassLoader();

        //从自定义类加载器 依次获取其对应的父加载器 最后到根加载器
        //可以得到结果是 AppClassLoader->ExtClassLoader->null  其中null代表的是启动类加载器（根加载器）
        //Java类加载有双亲委派模型：每当一个类加载器接收到记载请求时，它会先将请求转发给父类加载器，在父类加载器没有找到所请求类的情况下，该类加载器才会尝试去加载请求类
        while (classLoader != null) {
            System.out.print(classLoader.getClass().getName() + "->");
            //获取该加载器的父类加载器  null代表他的父加载器是 根加载器
            classLoader = classLoader.getParent();
        }
        System.out.println(classLoader);

        //jdk系统提供的类 rt中 都是使用根加载器 由于BootStrap根加载器不是Java编写 所以打印出来是null
        System.out.println(List.class.getClassLoader());

        //在jre/lib/ext 中的jar 都是扩展类加载器加载
        System.out.println(ZipInfo.class.getClassLoader());

        //Class c = classLoader.loadClass("ClassLoadDemo");

        System.out.println();


        AtomicInteger atomicInteger = new AtomicInteger();







    }

}
