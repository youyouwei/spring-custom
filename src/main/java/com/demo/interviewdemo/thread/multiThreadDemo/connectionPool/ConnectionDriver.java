package com.demo.interviewdemo.thread.multiThreadDemo.connectionPool;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.sql.Connection;
import java.util.concurrent.TimeUnit;

/**
 * @description:
 * 因为是模仿数据库连接，就直接反射代理生成连接对象
 * @author: jhyang
 * @create: 2019-06-27 17:09
 **/
public class ConnectionDriver {
    static class ConnectionHandler implements InvocationHandler {

        @Override
        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
            if (method.getName().equals("commit")) {
                //每次调用数据库提交操作 等待100ms 模仿数据库操作耗时
                TimeUnit.MILLISECONDS.sleep(100);
            }
            return null;
        }
    }
    //创建一个connection 的代理，在commit时休眠100毫秒
    public static final Connection createConnection() {
        return (Connection) Proxy.newProxyInstance(ConnectionDriver.class.getClassLoader(), new Class[]{Connection.class}, new ConnectionHandler());
    }
}
