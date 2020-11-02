package com.demo.interviewdemo.java8Demo.streamDemo;

/**
 * @Description: java8 后接口可以是函数接口  并且接口中可以定义默认方法 和 静态方法  其中默认方法可以被继承
 * @Author: jiahuiyang
 * @Date: Created in 15:55 2020/5/20
 */
@FunctionalInterface
public interface InterfaceDemo<T, R> {

    /**
     * 方法接口 匿名类需实现方法
     * @param t
     * @return
     */
    R apply(T t);

    /**
     * 接口默认方法
     * @param t
     * @return
     */
    default boolean check(T t) {
        return false;
    }

    /**
     * 接口静态方法
     * 静态方法使用泛型必须是确定泛型类型
     * @param v
     * @param v1
     * @param <V>
     * @return
     */
    static <V extends Number> int compare(V v, V v1) {
        return 0;
    }
}


