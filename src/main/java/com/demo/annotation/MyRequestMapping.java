package com.demo.annotation;

import org.springframework.core.annotation.AliasFor;

import java.lang.annotation.*;

@Documented
@Target({ElementType.TYPE,ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface MyRequestMapping {
    /**
     * 表示访问方法的url
     * @return
     */
    @AliasFor("path")
    String value() default "";

    /**
     * 访问路径别名
     * @return
     */
    String path() default "";
}
