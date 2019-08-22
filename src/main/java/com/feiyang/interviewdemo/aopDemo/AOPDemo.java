package com.feiyang.interviewdemo.aopDemo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @description:
 * @author: jhyang
 * @create: 2019-05-24 11:41
 **/
public class AOPDemo {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AOPConfigation.class);
        Landlord landlord = (Landlord) context.getBean("landlord");
        landlord.service();

    }
}
