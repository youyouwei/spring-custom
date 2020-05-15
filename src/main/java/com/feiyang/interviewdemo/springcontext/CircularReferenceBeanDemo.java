package com.feiyang.interviewdemo.springcontext;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @Description: 循环依赖bean
 * @Author: jiahuiyang
 * @Date: Created in 11:02 2020/5/13
 */
public class CircularReferenceBeanDemo {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(CustomerConfig.class);

        context.getBean(CircularDeference.class).method();

        context.getBean(CircularDeferenceAnother.class).method();

    }
}
