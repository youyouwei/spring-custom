package com.feiyang.interviewdemo.springDemo.springcontext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @Description:
 * @Author: jiahuiyang
 * @Date: Created in 11:03 2020/5/13
 */
@Component
public class CircularDeference {

    @Autowired
    private CircularDeferenceAnother circularDeferenceAnother;

    public void method() {

        System.out.println("circular deference");

    }
}
