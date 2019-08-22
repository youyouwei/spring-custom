package com.feiyang.interviewdemo.annotationAndReflect;

import java.lang.annotation.*;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface RuntimeAnnotation {

    String value() default "";

    String[] check() default {};
}
