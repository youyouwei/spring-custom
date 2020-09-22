package com.demo.interviewdemo.annotationAndReflect.fruitDemo;

import java.lang.annotation.*;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface FruitColor {
    /**
     * 颜色枚举
     */
    enum Color {BLUE,RED, GREEN}

    /**
     * 颜色属性
     * @return
     */
    Color fruitColor() default Color.GREEN;

}
