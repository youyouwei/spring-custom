package com.demo.interviewdemo.castClassDemo;

import lombok.Data;
import lombok.ToString;

/**
 * @Description: 类型转换
 * @Author: jiahuiyang
 * @Date: Created in 15:27 2020/11/12
 */
public class CastClassDemo {

    public static void main(String[] args) {
        method();
    }

    /**
     * 判断类型强转过程中是否会属性丢失
     * 验证结果 并未丢失
     * 父类转子类和子类转父类 运行过程中都是以实际初始化对象的类型处理的，不会因为强转出现运行过程中对象属性丢失的问题
     */
    public static void method() {
        Apple apple = new Apple();
        apple.setName("apple");
        apple.setKind("APPLE");

        System.out.println(apple.toString());

        Fruit fruit = apple;
        System.out.println(fruit.toString());

        Apple apple1 = (Apple) fruit;
        System.out.println(apple1.toString());

    }
}




@Data
class Fruit {
    private String kind;
}

@Data
@ToString(callSuper = true)
class Apple extends Fruit {
    private String name;
}

