package com.demo.interviewdemo.springDemo.annotationContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @Description:
 * @Author: jiahuiyang
 * @Date: Created in 17:17 2020/11/28
 */
@Component
public class CircleDependencyB {
    @Autowired
    private CircleDependencyC circleDependencyC;

    public CircleDependencyB() {
        System.out.println("create circleDependencyB");
    }
}
