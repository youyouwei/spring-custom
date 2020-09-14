package com.feiyang.interviewdemo.dynamicproxy;


import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @description: 代理类
 * @author: jhyang
 * @create: 2019-04-04 09:40
 **/
public class BeautyWangProxy implements InvocationHandler {


    //委托类
    private Object object;

    public BeautyWangProxy(Object object) {
        this.object = object;
    }

    public BeautyWangProxy() {

    }

    public Object wrap(Object object) {

        this.object = object;
        return Proxy.newProxyInstance(object.getClass().getClassLoader(), object.getClass().getInterfaces(), this);

    }


    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        beforeDoSomething();
        Object result = method.invoke(object, args);
        afterDoSomething();
        return result;
    }

    void beforeDoSomething() {
        System.out.println("做事之前准备");
    }

    void afterDoSomething() {
        System.out.println("做事之后处理");
    }
}


