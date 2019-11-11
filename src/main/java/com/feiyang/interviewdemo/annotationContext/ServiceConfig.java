package com.feiyang.interviewdemo.annocationContext;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * @description:
 * @author: jhyang
 * @create: 2019-04-17 14:07
 **/
@Configuration
@ComponentScan("com.feiyang.interviewdemo.annocationContext")
@EnableAspectJAutoProxy(proxyTargetClass = true)
public class ServiceConfig {
}
