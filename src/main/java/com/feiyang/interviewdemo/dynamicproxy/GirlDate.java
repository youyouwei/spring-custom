package com.feiyang.interviewdemo.dynamicproxy;

import java.lang.reflect.Proxy;

/**
 * @description: 使用类
 * @author: jhyang
 * @create: 2019-04-04 09:42
 **/
public class GirlDate {

    public static void main(String[] args) {
        //约会
        //创建代理中介类，并传入实际类
        BeautyWangProxy proxy = new BeautyWangProxy(new BeautyWang());

        System.getProperties().put("sun.misc.ProxyGeneratedFiles", "true");

        //通过动态代理获取对象  使用被代理对象实现接口进行实际调用处理
        Girl girl = (Girl) Proxy.newProxyInstance(Girl.class.getClassLoader(), new Class[]{Girl.class}, proxy);

        girl.eat();
        System.out.println("-------------------------------------");
        girl.watchMovie();

    }

}
