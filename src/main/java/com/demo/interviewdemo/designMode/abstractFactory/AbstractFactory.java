package com.demo.interviewdemo.designMode.abstractFactory;

import com.demo.interviewdemo.designMode.simpleFactory.Car;

/**
 * @description:
 * @author: jhyang
 * @create: 2019-06-28 20:44
 **/
public abstract class AbstractFactory {

    public abstract Car getAudiCar();

    public abstract Car getBenzCar();

    public abstract Car getBmwCar();
}
