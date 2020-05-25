package com.feiyang.interviewdemo.springDemo.springcontext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @Description:
 * @Author: jiahuiyang
 * @Date: Created in 11:04 2020/5/13
 */
@Component
public class CircularDeferenceAnother {
    @Autowired
    private CircularDeference circularDeference;

    public void method() {

        System.out.println("circular deference another");

    }
}
