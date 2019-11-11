package com.feiyang.interviewdemo.annotationContext;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @description:
 * @author: jhyang
 * @create: 2019-04-17 14:07
 **/
public class AnnocationContextDemo {

    public static void main(String[] args) {

        ApplicationContext context = new AnnotationConfigApplicationContext(ServiceConfig.class);

        DemoService service = context.getBean(DemoService.class);

        service.method();
    }

}
