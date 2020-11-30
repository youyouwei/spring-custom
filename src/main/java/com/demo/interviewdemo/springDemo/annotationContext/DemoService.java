package com.demo.interviewdemo.springDemo.annotationContext;

import org.springframework.stereotype.Service;

/**
 * @description:
 * @author: jhyang
 * @create: 2019-04-17 14:09
 **/
@Service
public class DemoService {
    public void method() {
        System.out.println("annotation context");
    }
}
