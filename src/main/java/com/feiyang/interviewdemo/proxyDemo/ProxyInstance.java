package com.feiyang.interviewdemo.proxyDemo;

import sun.awt.Mutex;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.AbstractQueuedSynchronizer;

/**
 * @description:
 * 代理实例
 * @author: jhyang
 * @create: 2019-06-28 11:46
 **/
public class ProxyInstance {

    static class CheckInvocationHandler implements InvocationHandler {

        /**
         *
         * @param proxy  代理对象 com.sun.proxy.$Proxy0
         * @param method 被代理对象的方法 com.feiyang.interviewdemo.proxyDemo.SecurityCheck
         * @param args
         * @return
         * @throws Throwable
         */
        @Override
        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

            if (method.getName().equals("check")) {

                System.out.println(proxy.getClass().getName());
                System.out.println(method.getDeclaringClass().getName());

                TimeUnit.MILLISECONDS.sleep(1000);
                System.out.println("invoke sleep 1 second");

            }
            return null;
        }
    }

    public static void main(String[] args) {
        SecurityCheck securityCheck = (SecurityCheck) Proxy.newProxyInstance(ProxyInstance.class.getClassLoader(), new Class[]{SecurityCheck.class}, new CheckInvocationHandler());
        securityCheck.check();
    }

}
