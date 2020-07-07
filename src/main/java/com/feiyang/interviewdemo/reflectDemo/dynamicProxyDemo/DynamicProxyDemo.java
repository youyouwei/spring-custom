package com.feiyang.interviewdemo.reflectDemo.dynamicProxyDemo;

import java.lang.reflect.Proxy;

/**
 * @Description: jdk动态代理
 * @Author: jiahuiyang
 * @Date: Created in 18:00 2020/6/17
 */
public class DynamicProxyDemo {

    public static void main(String[] args) {

        method();

    }

    public static void method() {
        Class<?>[] classes = {Person.class};
        Person person = (Person) Proxy.newProxyInstance(DynamicProxyDemo.class.getClassLoader(), classes, new PeronInvocationHandler());
        person.role();

    }

}
