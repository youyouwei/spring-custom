package com.demo.interviewdemo.springDemo.annotationContext;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * @Description: scope 为 prototype的bean
 * @Author: jiahuiyang
 * @Date: Created in 20:57 2020/11/28
 */
@Component
@Scope("prototype")
public class PrototypeBean {


}
