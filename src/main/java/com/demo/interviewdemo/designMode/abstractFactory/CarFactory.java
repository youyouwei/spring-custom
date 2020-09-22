package com.demo.interviewdemo.designMode.abstractFactory;

import com.demo.interviewdemo.designMode.simpleFactory.Audi;
import com.demo.interviewdemo.designMode.simpleFactory.Benz;
import com.demo.interviewdemo.designMode.simpleFactory.Bmw;
import com.demo.interviewdemo.designMode.simpleFactory.Car;

/**
 * @description:
 * @author: jhyang
 * @create: 2019-06-28 20:46
 **/
public class CarFactory extends AbstractFactory {
    @Override
    public Car getAudiCar() {
        return new Audi();
    }

    @Override
    public Car getBenzCar() {
        return new Benz();
    }

    @Override
    public Car getBmwCar() {
        return new Bmw();
    }
}
