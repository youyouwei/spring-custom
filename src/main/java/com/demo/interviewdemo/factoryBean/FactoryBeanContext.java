package com.demo.interviewdemo.factoryBean;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @description:
 * @author: jhyang
 * @create: 2019-05-30 10:28
 **/
public class FactoryBeanContext {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(FactoryBeanConfig.class);


        DemoService demoService = (DemoService) context.getBean("demoServiceProxy");



        demoService.doST();

        DemoService demoServiceNew = (DemoService) SpringContextUtilNew.getBean("demoServiceProxy");
        demoServiceNew.doST();



    }
}
