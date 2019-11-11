package com.feiyang.interviewdemo.annotationContext;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

/**
 * @description:
 * @author: jhyang
 * @create: 2019-04-17 14:31
 **/
@Component
@Aspect
public class DemoAspect {

    @Before(value = "com.feiyang.interviewdemo.annotationContext.DemoService.method()")
    public void before() {

        System.out.println("pointCut 执行前");

    }


    @After(value = "com.feiyang.interviewdemo.annotationContext.DemoService.method()")
    public void after() {

        System.out.println("pointCut 执行后");

    }
}
