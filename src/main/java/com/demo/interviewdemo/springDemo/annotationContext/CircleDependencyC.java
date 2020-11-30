package com.demo.interviewdemo.springDemo.annotationContext;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

/**
 * @Description:
 * @Author: jiahuiyang
 * @Date: Created in 17:17 2020/11/28
 */
@Component
@Lazy
public class CircleDependencyC {
    private CircleDependencyA circleDependencyA;

    public CircleDependencyC(CircleDependencyA circleDependencyA) {
        System.out.println("create circleDependencyC");
        this.circleDependencyA = circleDependencyA;
    }
}
