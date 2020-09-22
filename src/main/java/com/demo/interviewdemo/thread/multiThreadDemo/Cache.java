package com.demo.interviewdemo.thread.multiThreadDemo;

import java.util.Hashtable;
import java.util.Map;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @description: 读写锁的缓存使用实例
 * Cache组合一个非线程安全的HashMap作为缓存的实现，同时使用读写锁的
 * 读锁和写锁来保证Cache是线程安全的。
 * @author: jhyang
 * @create: 2019-06-30 16:19
 **/
public class Cache {
    static Map<String, Object> map = new Hashtable<>();
    static ReentrantReadWriteLock rwl = new ReentrantReadWriteLock();
    static Lock read = rwl.readLock();
    static Lock write = rwl.writeLock();


    /**
     *     //获取对应的key的value
     * @param key
     * @return
     */
    public static final Object get(String key) {
        read.lock();
        try {
            return map.get(key);
        }finally {
            read.unlock();
        }
    }

    /**
     * 设置key对应的value 并且返回旧的value
     * @param key
     * @param value
     * @return
     */
    public static final Object put(String key, Object value) {
        write.lock();
        try {
            return map.put(key, value);
        }finally {
            write.unlock();
        }
    }

    /**
     * 清空所有内容
     */
    public static final void clear() {
        write.lock();
        try {
            map.clear();
        }finally {
            write.unlock();
        }
    }

}
