package com.feiyang.annotation;

import org.springframework.core.annotation.AliasFor;

import java.lang.annotation.*;

@Target(ElementType.PARAMETER)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface RequestParam {
    /**
     * @return
     */
    String value();

}
