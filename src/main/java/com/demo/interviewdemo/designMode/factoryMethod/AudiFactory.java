package com.demo.interviewdemo.designMode.factoryMethod;

import com.demo.interviewdemo.designMode.simpleFactory.Audi;
import com.demo.interviewdemo.designMode.simpleFactory.Car;

/**
 * @description:
 * @author: jhyang
 * @create: 2019-06-28 20:38
 **/
public class AudiFactory implements Factory {
    @Override
    public Car getCar() {
        return new Audi();
    }
}
