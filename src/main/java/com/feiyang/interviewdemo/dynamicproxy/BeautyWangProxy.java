package com.feiyang.interviewdemo.dynamicproxy;


import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

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


