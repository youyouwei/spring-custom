package com.feiyang.interviewdemo.springcontext;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @description: 自定义手动加载spring context
 * @author: jhyang
 * @create: 2019-04-11 16:07
 **/
public class SpringContextDemo {

    public static void main(String[] args) {

        //自定义容器
        ApplicationContext context = new ClassPathXmlApplicationContext("classpath:beans.xml");
        //获取bean
        User user = (User) context.getBean("user");
        System.out.println(user);

    }

}