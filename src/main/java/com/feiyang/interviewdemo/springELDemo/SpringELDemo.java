package com.feiyang.interviewdemo.springELDemo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @description:
 * @author: jhyang
 * @create: 2019-06-27 11:06
 **/
public class SpringELDemo {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SpringELConfig.class);
        Customer customer = (Customer) context.getBean("customerBean");
        System.out.println(customer);
    }

}
