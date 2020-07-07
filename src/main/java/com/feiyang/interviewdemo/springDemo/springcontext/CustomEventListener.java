package com.feiyang.interviewdemo.springDemo.springcontext;

import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

/**
 * @Description:
 * @Author: jiahuiyang
 * @Date: Created in 16:02 2020/7/7
 */
@Component
public class CustomEventListener implements ApplicationListener<CustomApplicationEvent> {
    @Override
    public void onApplicationEvent(CustomApplicationEvent event) {
        System.out.println("=========== Custom Event Listen");
    }
}
