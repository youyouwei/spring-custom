package com.feiyang.interviewdemo.designMode.factoryMethod;

import com.feiyang.interviewdemo.designMode.simpleFactory.Audi;
import com.feiyang.interviewdemo.designMode.simpleFactory.Car;

import java.security.PublicKey;

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
