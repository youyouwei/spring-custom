package com.demo.interviewdemo.collectionOperDemo;

import org.springframework.util.CollectionUtils;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * @Description: JDK集合工具类 和 spring framework的集合工具类
 *   Collections 和 CollectionUtils
 *   其中CollectionUtils中封装了判断集合是否为空和集合中查找元素或则判断是否包含该元素
 *   Collections中封装了创建集合和为集合排序等
 *
 * @Author: jiahuiyang
 * @Date: Created in 18:28 2020/3/21
 */
public class CollectionsDemo {

    public static void main(String[] args) {

    }

    /**
     * 获取线程安全的集合
     *
     */
    public static void method() {
        Map<String, String> map = new HashMap<>();
//        Collections 会生成一个SynchronizedMap 内部静态类，其中定义个object锁对象，对map操作进行上锁处理
        map = Collections.synchronizedMap(map);





    }
}
