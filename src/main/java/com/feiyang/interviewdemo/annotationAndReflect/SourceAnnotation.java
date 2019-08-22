package com.feiyang.interviewdemo.annotationAndReflect;

import java.lang.annotation.*;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.SOURCE)
@Documented
public @interface SourceAnnotation {
}
