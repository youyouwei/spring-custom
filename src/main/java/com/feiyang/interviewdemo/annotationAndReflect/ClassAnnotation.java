package com.feiyang.interviewdemo.annotationAndReflect;

import java.lang.annotation.*;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.CLASS)
@Documented
public @interface ClassAnnotation {
}