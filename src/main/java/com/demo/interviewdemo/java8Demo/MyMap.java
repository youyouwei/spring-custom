package com.demo.interviewdemo.java8Demo;

import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description:
 * @Author: jiahuiyang
 * @Date: Created in 15:18 2020/5/20
 */
@FunctionalInterface
public interface MyMap<T, R> {
    /**
     * 函数接口 操作方法 传入T经过函数处理返回R
     * @param t
     * @return
     */
    R operate(T t);

    /**
     * 接口静态方法实现map映射
     * @param map
     * @param list
     * @param <V>
     * @param <E>
     * @return
     */
    static <V, E> List<E> map(MyMap<V, E> map, List<V> list) {
        if (map == null || CollectionUtils.isEmpty(list)) {
            return null;
        }
        List<E> results = new ArrayList<>();
        list.forEach(e -> results.add(map.operate(e)));
        return results;
    }
}
