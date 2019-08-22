package com.feiyang.interviewdemo.factoryBean;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @description:
 * @author: jhyang
 * @create: 2019-05-30 10:49
 **/
public class WorkHandler implements InvocationHandler {

    private Object obj;

    public WorkHandler() {

    }

    public WorkHandler(Object obj) {
        this.obj = obj;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        System.out.println("before invoke...");
        Object invoke = method.invoke(obj, args);
        System.out.println("after invoke...");
        return invoke;
    }

    public static void main(String[] args) {
        DemoServiceImpl demoService = new DemoServiceImpl();



        DemoService demoServiceProxy = (DemoService) Proxy.newProxyInstance(demoService.getClass().getClassLoader(), demoService.getClass().getInterfaces(),
                new WorkHandler(demoService));

        demoServiceProxy.doST();

    }

}
