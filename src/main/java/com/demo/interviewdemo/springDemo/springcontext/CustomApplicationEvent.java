package com.demo.interviewdemo.springDemo.springcontext;

import org.springframework.context.ApplicationEvent;

/**
 * @Description: 自定义Spring ApplicationEvent
 *
 * @Author: jiahuiyang
 * @Date: Created in 15:59 2020/7/7
 */
public class CustomApplicationEvent extends ApplicationEvent {
    public CustomApplicationEvent(Object source, final String msg) {
        super(source);
    }
}
