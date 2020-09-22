package com.demo.interviewdemo.springDemo.springcontext;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @description: 自定义手动加载spring context
 * @author: jhyang
 * @create: 2019-04-11 16:07
 **/
public class SpringContextDemo {

    public static void main(String[] args) {

//        //自定义容器
//        ApplicationContext context = new ClassPathXmlApplicationContext("classpath:beans.xml");
//        //获取bean
//        User user = (User) context.getBean("user");
//        System.out.println(user);

        annotationDemo();

    }

    public static void annotationDemo() {
        ApplicationContext context = new AnnotationConfigApplicationContext(CustomerConfig.class);
        //添加自定义ApplicationEvent
        context.publishEvent(new CustomApplicationEvent(new Object(), "none"));
        MedicineService medicineService = context.getBean(MedicineService.class);
        medicineService.eatMedicine();

    }

}