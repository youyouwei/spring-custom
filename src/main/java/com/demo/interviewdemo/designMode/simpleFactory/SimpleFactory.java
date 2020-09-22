package com.demo.interviewdemo.designMode.simpleFactory;

/**
 * @description:
 * @author: jhyang
 * @create: 2019-06-28 20:26
 **/
public class SimpleFactory {
    public Car getCar(String name) {
        if ("BMW".equalsIgnoreCase(name)) {
            return new Bmw();
        } else if ("Benz".equalsIgnoreCase(name)) {
            return new Benz();
        } else if ("Audi".equalsIgnoreCase(name)) {
            return new Audi();
        } else {
            System.out.println("这个产品不出来");
            return null;
        }
    }
}
