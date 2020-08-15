package com.feiyang.interviewdemo.thread.threadCommunication;

import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @Description:
 * @Author: jiahuiyang
 * @Date: Created in 9:45 2020/8/2
 */
public class TestClass {

    private HashMap<String, String> map = new HashMap<>();
    private ConcurrentHashMap<String, String> concurrentHashMap = new ConcurrentHashMap<>();


    public synchronized void add(String key) {
        String value = map.get(key);
        if (value == null) {
            map.put(key, "1");
        } else {
            map.put(key, "2");
        }
    }

    /**
     * 这种也是有问题的 因为对线程安全的操作不是原子性的也会出问你
     * @param key
     */
    public void addConcurrentMap(String key) {
        String value = concurrentHashMap.get(key);
        if (value == null) {
            concurrentHashMap.put(key, "1");
        } else {
            concurrentHashMap.put(key, "2");
        }
    }

}
