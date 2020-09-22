package com.demo.interviewdemo.springDemo.springcontext;

import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.FileSystemResource;

import java.io.File;

/**
 * @Description: spring bean definition IOC 容器加载bean过程
 * @Author: jiahuiyang
 * @Date: Created in 10:51 2020/5/13
 */

public class SpringBeanDefinitionDemo {

    public static void main(String[] args) {
        ClassPathResource resource = new ClassPathResource("beans.xml");
        FileSystemResource fileResource = new FileSystemResource(new File("D:\\code\\spring-custom\\src\\main\\java\\com\\demo\\interviewdemo\\springcontext\\beans.xml"));

//        DefaultListableBeanFactory内部定义了存放beanDefinition 和 beanName的map
        DefaultListableBeanFactory factory = new DefaultListableBeanFactory();
//        beanDefinition加载器
        XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(factory);
//        根据resource加载bean
        reader.loadBeanDefinitions(resource);
    }

}
