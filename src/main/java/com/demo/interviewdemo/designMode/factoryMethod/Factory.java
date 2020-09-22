package com.demo.interviewdemo.designMode.factoryMethod;

import com.demo.interviewdemo.designMode.simpleFactory.Car;
import org.apache.commons.lang3.StringUtils;

import java.security.InvalidParameterException;

/**
 * @description:
 * @author: jhyang
 * @create: 2019-06-28 20:37
 **/
public interface Factory {
    Car getCar();

    static Car factoryMethod(String type) {
        if (StringUtils.isNotEmpty(type)) {
            type = type.toLowerCase();
            Factory factory;
            switch (type) {
                case "audi":
                    factory = new AudiFactory();
                    break;
                case "benz":
                    factory = new BenzFactory();
                    break;
                case "bmw":
                    factory = new BmwFactory();
                    break;
                default:
                    factory = null;
                    break;
            }
            return factory == null ? null : factory.getCar();
        }
        throw new InvalidParameterException("invalid parameter by type");

    }
}
