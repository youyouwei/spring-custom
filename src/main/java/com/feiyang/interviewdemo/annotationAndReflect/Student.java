package com.feiyang.interviewdemo.annotationAndReflect;

/**
 * @description:
 * @author: jhyang
 * @create: 2019-04-22 11:36
 **/
@RuntimeAnnotation("student")
public class Student {
    public void study() {
        System.out.println("----student study----");
    }
}
