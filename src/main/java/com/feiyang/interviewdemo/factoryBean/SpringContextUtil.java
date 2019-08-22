package com.feiyang.interviewdemo.factoryBean;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import java.util.Locale;

/**
 * @description:
 * @author: jhyang
 * @create: 2019-05-30 11:32
 **/
@Component
public class SpringContextUtil implements ApplicationContextAware {

    private static ApplicationContext context;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        System.out.println("---------------context--------------" + applicationContext);
        SpringContextUtil.context = applicationContext;
    }

    public static ApplicationContext getApplicationContext() {
        return context;
    }

    public static Object getBean(String beanName) {
        return context.getBean(beanName);
    }

    public static String getMessage(String key) {
        return context.getMessage(key, null, Locale.getDefault());
    }

    public static void main(String[] args) {
        System.out.println(getMessage("name"));

    }
}
