package com.demo.interviewdemo.designMode.factoryMethod;

import com.demo.interviewdemo.designMode.simpleFactory.Benz;
import com.demo.interviewdemo.designMode.simpleFactory.Car;

/**
 * @description:
 * @author: jhyang
 * @create: 2019-06-28 20:39
 **/
public class BenzFactory implements Factory {
    @Override
    public Car getCar() {
        return new Benz();
    }
}
