package com.feiyang.interviewdemo.designMode.factoryMethod;

/**
 * @description:
 * @author: jhyang
 * @create: 2019-06-28 20:40
 **/
public class FactoryTest {
    public static void main(String[] args) {
        //每种产品有自己的工厂
        Factory factory = new AudiFactory();

        System.out.println(factory.getCar());
        factory = new BmwFactory();
        System.out.println(factory.getCar());
    }
}
