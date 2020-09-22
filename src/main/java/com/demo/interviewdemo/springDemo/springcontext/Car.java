package com.demo.interviewdemo.springDemo.springcontext;

import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/**
 * @Description:
 * @Author: jiahuiyang
 * @Date: Created in 16:48 2020/6/3
 */
@Component
@NoArgsConstructor
public class Car {
    @PostConstruct
    public void init() {
        System.out.println("========car init========");
    }

    @PreDestroy
    public void destroy() {
        System.out.println("========car destroy========");
    }
}

