package com.feiyang.interviewdemo.springDemo.springBeanDemo;

import com.feiyang.interviewdemo.thread.Run;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import javax.lang.model.element.NestingKind;
import java.util.Map;

/**
 * @Description:
 * @Author: jiahuiyang
 * @Date: Created in 11:18 2019/11/19
 */
@Component
public class SpringContextUtil implements InitializingBean, ApplicationContextAware {

    private static ApplicationContext applicationContext;

    @Override
    public void afterPropertiesSet() throws Exception {

    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        SpringContextUtil.applicationContext = applicationContext;
    }

    public static ApplicationContext getApplicationContext() {
        if (applicationContext != null) {
            return applicationContext;
        }
        throw new RuntimeException("applicationContext not initializing");
    }

    public static <T> T getBean(String name) {
        return (T) getApplicationContext().getBean(name);
    }

    public static <T> T getBean(Class<T> tClass) {
        Map<String, T> beanMaps = getApplicationContext().getBeansOfType(tClass);
        return beanMaps != null && !beanMaps.isEmpty() ? beanMaps.values().iterator().next() : null;
    }

}
