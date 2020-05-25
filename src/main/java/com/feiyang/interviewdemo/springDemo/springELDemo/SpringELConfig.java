package com.feiyang.interviewdemo.springDemo.springELDemo;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 * @description:
 * @author: jhyang
 * @create: 2019-06-27 11:05
 **/
@Configuration
@ComponentScan("com.feiyang.interviewdemo.springDemo.springELDemo")
@PropertySource(value = {"classpath:app.properties", "classpath:config.properties"})
public class SpringELConfig {
}
