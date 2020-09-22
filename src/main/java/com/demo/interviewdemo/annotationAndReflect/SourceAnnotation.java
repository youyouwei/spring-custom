package com.demo.interviewdemo.annotationAndReflect;

import java.lang.annotation.*;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.SOURCE)
@Documented
public @interface SourceAnnotation {
}
