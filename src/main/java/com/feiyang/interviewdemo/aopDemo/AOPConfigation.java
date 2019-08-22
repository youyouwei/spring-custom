package com.feiyang.interviewdemo.aopDemo;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * @description:
 * @author: jhyang
 * @create: 2019-05-24 11:43
 **/
@Configuration
@ComponentScan("com.feiyang.interviewdemo.aopDemo")
@EnableAspectJAutoProxy
public class AOPConfigation {


}
