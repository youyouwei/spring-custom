package com.feiyang.interviewdemo.reflectDemo.dynamicProxyDemo;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @Description: 具体invoke 代理执行方法
 * @Author: jiahuiyang
 * @Date: Created in 18:03 2020/6/17
 */
public class PeronInvocationHandler implements InvocationHandler {

    private Person person;

    public PeronInvocationHandler(Person person) {
        this.person = person;
    }

    public PeronInvocationHandler() {

    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("执行前=========");
        method.invoke(person, args);
        System.out.println("执行后=========");
        return proxy;
    }

}
