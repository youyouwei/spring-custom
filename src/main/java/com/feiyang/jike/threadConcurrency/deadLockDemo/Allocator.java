package com.feiyang.jike.threadConcurrency.deadLockDemo;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description: 分配器 锁资源由一个统一的分配器处理 这个分配器必须满足单例
 * @Author: jiahuiyang
 * @Date: Created in 11:53 2019/12/16
 */
public class Allocator {

    private Allocator() { }

    private static final Allocator ALLOCATOR = new Allocator();

    public static Allocator getInstance() {
        return ALLOCATOR;
    }

    private List<Object> als = new ArrayList<>();

    public synchronized boolean apply(Object from, Object to) {
        if (als.contains(from) || als.contains(to)) {
            return false;
        } else {
            als.add(from);
            als.add(to);
        }
        return true;

    }

    public synchronized void free(Object from, Object to) {
        als.remove(from);
        als.remove(to);
    }


}
