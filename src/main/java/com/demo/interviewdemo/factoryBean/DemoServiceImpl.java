package com.demo.interviewdemo.factoryBean;

import org.springframework.stereotype.Component;

/**
 * @description:
 * @author: jhyang
 * @create: 2019-05-30 10:16
 **/
@Component
public class DemoServiceImpl implements DemoService {

    @Override
    public void doST() {
        System.out.println("do something");
    }

}
