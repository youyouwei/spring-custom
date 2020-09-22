package com.demo.interviewdemo.springDemo.anntation;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Description:
 * @Author: jiahuiyang
 * @Date: Created in 11:38 2019/11/5
 */
@Configuration
public class DemoConfig {

    @Bean
    public Phone phone() {
        return new Phone();
    }

    public void demoMethod() {
        System.out.println("demo config");
    }

}
