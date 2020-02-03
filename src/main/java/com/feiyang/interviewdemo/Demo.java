package com.feiyang.interviewdemo;

import com.sun.org.apache.bcel.internal.generic.NEWARRAY;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import sun.misc.Unsafe;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Stream;

/**
 * @description:
 * @author: jhyang
 * @create: 2019-04-02 17:49
 **/
@Slf4j
public class Demo {
    private static Logger logger = LoggerFactory.getLogger(Demo.class);

    private static org.apache.log4j.Logger loggerNew = org.apache.log4j.Logger.getLogger(Demo.class);
    public static void main(String[] args) throws Exception {

       /* System.out.println("日志打印");
        logger.info("slf4j log ");

        loggerNew.info("dddd");

        log.info("ssdsds");

        Object o = null;*/

//        AtomicInteger atomicInteger = new AtomicInteger(); //第一次初始化是0

        //for (int i = 0; i < 100; i++) {
        //    System.out.println(atomicInteger.incrementAndGet()); //先加然后返回 相当于++i
        //}

        //for (int i = 0; i < 100; i++) {
        //
        //    System.out.println(atomicInteger.getAndIncrement());  //先返回然后再加 相当于i++
        //
        //}

        /*
        int i = 0;

        //for (int j = 0; j < 100; j++) {
        //    System.out.println(++i);
        //}

        for (int j = 0; j < 100; j++) {
            System.out.println(i++);
        }*/
        //proxyDemoMethod();
        //method();

        //linkListDemo();

//        int oldCapacity = 15;
//        int newCapacity = oldCapacity + (oldCapacity >> 1);
//
//        System.out.println(newCapacity + "tom+jack");

//        int oldCapacity = 15;
//        int newCapacity = oldCapacity + (oldCapacity >> 1);
//        System.out.println(newCapacity);
//
//        Map<String, String> map = new Hashtable<>();
//
//        List<String> list = new ArrayList<>();
//
//        Stream s = list.stream();

        method1();

    }


    public static void method1() throws IOException {
        System.out.println("请输入你的名称并按回车键结束！");
        byte[] bytes = new byte[1024];
        System.in.read(bytes);
        System.out.println("你输入的是：" + new String(bytes));





    }

    /**
     * 反射调用方法
     * @throws IllegalAccessException
     * @throws InstantiationException
     */
    public static void proxyDemoMethod() throws Exception {

        //获取Class对象
        Class c = Demo.class;
        Demo demo = (Demo) c.newInstance();

        //不知道该方法名是否存在 如果不存在该方法会自动抛出异常
        Method method = c.getMethod("reflectMethod");
        method.invoke(c.newInstance(), null);
        //知道类中方法名
        demo.reflectMethod();
    }

    public void reflectMethod() {
        System.out.println("reflect method");
    }

    public static void method() {
        List<String> list = new ArrayList<>();
        list.add(null);
        list.add(null);
        list.add(null);
        list.add(null);
        //list.forEach(System.out::println);

        Set<String> set = new HashSet<>();
        set.add(null);
        set.add(null);
        set.add(null);
        set.add(null);
        set.forEach(System.out::println);

    }


    public static void linkListDemo() {
        //LinkList 没有容量限制

        List<String> list = new LinkedList<String>();
        list.add("1");
        list.add("2");
        list.add("3");
        list.add("4");
        list.add("5");
        for (String s : list) {
            System.out.println(s);

        }

    }

}

