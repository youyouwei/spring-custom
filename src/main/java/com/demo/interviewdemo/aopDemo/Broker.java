package com.demo.interviewdemo.aopDemo;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

/**
 * @description:
 * @author: jhyang
 * @create: 2019-05-24 11:38
 **/
@Component
@Aspect
public class Broker {
    @Before("execution(* com.demo.interviewdemo.aopDemo.Landlord.service())")
    public void before() {
        System.out.println("带租客看房");
        System.out.println("谈价格");
    }

    @After("execution(* com.demo.interviewdemo.aopDemo.Landlord.service())")
    public void after() {
        System.out.println("交钥匙");
    }
}
