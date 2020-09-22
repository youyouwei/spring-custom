package com.demo.interviewdemo.annotationContext;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Service;

/**
 * @description:
 * @author: jhyang
 * @create: 2019-04-17 14:09
 **/
@Service
@Aspect
public class DemoService {
    @Pointcut("@annotation(com.demo.interviewdemo.annotationContext.DemoAspect)")
    public void method() {
        System.out.println("annotation context");
    }
}
