package com.feiyang.interviewdemo.springDemo.springcontext;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

/**
 * @Description:
 * @Author: jiahuiyang
 * @Date: Created in 15:54 2020/7/7
 */
@Component
public class CustomBean implements ApplicationListener<ContextRefreshedEvent> {


    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        System.out.println("============ CustomBean =============");
    }
}
