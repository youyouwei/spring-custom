package com.demo.interviewdemo.springDemo.beanFactory;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

/**
 * @Description:
 * @Author: jiahuiyang
 * @Date: Created in 10:46 2020/11/29
 */
@SuppressWarnings("deprecation")
public class BeanFactoryTest {

    public static void main(String[] args) {
        Resource resource;
        BeanFactory beanFactory = new XmlBeanFactory(new ClassPathResource("beanFactoryTest.xml"));
        MyTestBean myTestBean = beanFactory.getBean(MyTestBean.class);

        System.out.println(myTestBean.getTestStr());
    }

}
