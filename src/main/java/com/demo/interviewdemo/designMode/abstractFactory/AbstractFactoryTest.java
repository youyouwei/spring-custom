package com.demo.interviewdemo.designMode.abstractFactory;

import com.demo.interviewdemo.designMode.simpleFactory.Car;

/**
 * @description:
 * @author: jhyang
 * @create: 2019-06-28 20:47
 **/
public class AbstractFactoryTest {
    public static void main(String[] args) {
        AbstractFactory abstractFactory = new CarFactory();
        Car audi = abstractFactory.getAudiCar();
        System.out.println(audi.getName());

    }
}
