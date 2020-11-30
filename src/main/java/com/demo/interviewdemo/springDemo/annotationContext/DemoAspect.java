package com.demo.interviewdemo.springDemo.annotationContext;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * @description:
 * @author: jhyang
 * @create: 2019-04-17 14:31
 **/
@Component
@Aspect
public class DemoAspect {

    @Pointcut("execution( * com.demo.interviewdemo.springDemo.annotationContext.*.*(..) )")
    public void demo() {}

    @Before("demo()")
    public void before() {
        System.out.println("pointCut 执行前");
    }

    @After("demo()")
    public void after() {
        System.out.println("pointCut 执行后");
    }
}
