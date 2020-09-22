package com.demo.interviewdemo.springDemo;

import com.demo.interviewdemo.springDemo.springBeanDemo.CommonService;
import com.demo.interviewdemo.springDemo.springBeanDemo.SpringContextUtil;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @Description: annotationConfigApplicationContext 初始化 传入带spring bean 注解的类
 * 把这些类注入容器 并且通过这些类可以配置bean 和 扫描bean 的包路径
 * @Author: jiahuiyang
 * @Date: Created in 11:37 2019/11/5
 */
public class SpringDemo {
    public static void main(String[] args) {

//        AnnotationConfigApplicationContext annotationConfigApplicationContext = new AnnotationConfigApplicationContext(DemoConfig.class);
//        AnnotationConfigApplicationContext annotationConfigApplicationContext = new AnnotationConfigApplicationContext(DemoConfig.class, Phone.class);
        /*AnnotationConfigApplicationContext annotationConfigApplicationContext = new AnnotationConfigApplicationContext(Phone.class);

        Phone phone = annotationConfigApplicationContext.getBean(Phone.class);
        phone.setName("华为");

        DemoConfig demoConfig = annotationConfigApplicationContext.getBean(DemoConfig.class);
        demoConfig.demoMethod();

        Charger charger = annotationConfigApplicationContext.getBean(Charger.class);
        charger.setModel("iphone");

        System.out.println(phone.getName());
        System.out.println(charger.getModel());*/

        springContextUtil();

    }

    public static void springContextUtil() {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(ConfigDemo.class);

        CommonService commonService = SpringContextUtil.getBean("commonService");
        commonService.valid();

//        CommonService  commonService = (CommonService) applicationContext.getBean("commonService");
//        commonService.valid();

    }



}
