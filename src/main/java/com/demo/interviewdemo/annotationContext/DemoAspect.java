package com.demo.interviewdemo.annotationContext;

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
//去掉 Aspect spring boot检测注册报错
//@Aspect
public class DemoAspect {

    @Before(value = "DemoService.method()")
    public void before() {

        System.out.println("pointCut 执行前");

    }


    @After(value = "DemoService.method()")
    public void after() {

        System.out.println("pointCut 执行后");

    }
}
