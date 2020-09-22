package com.demo.interviewdemo.designMode.factoryMethod;

import com.demo.interviewdemo.designMode.simpleFactory.Bmw;
import com.demo.interviewdemo.designMode.simpleFactory.Car;

/**
 * @description:
 * @author: jhyang
 * @create: 2019-06-28 20:40
 **/
public class BmwFactory implements Factory{
    @Override
    public Car getCar() {
        return new Bmw();
    }
}
