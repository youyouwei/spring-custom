package com.demo.interviewdemo.annotationContext;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * @description:
 * @author: jhyang
 * @create: 2019-04-17 14:07
 **/
@Configuration
@ComponentScan("com.demo.interviewdemo.annotationContext")
@EnableAspectJAutoProxy(proxyTargetClass = true)
public class ServiceConfig {
}
