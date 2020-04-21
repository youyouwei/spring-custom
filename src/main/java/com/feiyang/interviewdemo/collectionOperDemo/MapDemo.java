package com.feiyang.interviewdemo.collectionOperDemo;

import java.io.Serializable;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

/**
 * @description: Map key值不能重复和无序性
 * @author: jhyang
 * @create: 2019-07-19 13:25
 **/
public class MapDemo {

    /**
     * 通常HashMap是无序的
     */
    private static Map<String, String> map = new Hashtable<>();

    static {
        map.put("1", "tom");
        map.put("2", "jack");
        map.put("3", "tim");
    }

    public static void main(String[] args) {
        //map的无序性 如果需要使用

        //System.out.println(map);

        //mapSort();

        checkIfHasKey();

        ArrayList list = new ArrayList();

        list.add("name");
        list.add(1);






    }

    /**
     * map 排序
     * 1、将Map转换为Stream
     * 2、对其进行排序
     * 3、Collect and return a new LinkedHashMap（有序）
     */
    public static void mapSort() {

        Object object = new Object();
        object = 1;

        Integer i = (Integer & Serializable) object;

        System.out.println(i);

        System.out.println(map);

        Map<String, String> result = map.entrySet().stream().sorted(Map.Entry.comparingByKey())
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (k, v) -> k, LinkedHashMap::new));

        System.out.println(result);


    }


    public static void checkIfHasKey() {

        Map<String, String> map = new HashMap<>();
        map.put("name", null);
        map.put("addr", "ccc");
        //判断是否是
        System.out.println(map.containsKey("name"));
        //不能通过 value 是否为null 判断key是否存在
        System.out.println(map.get("name") != null);
        System.out.println(map.containsKey("jack"));


    }

    /**
     * ConcurrentHashMap 使用
     */
    public static void concurrentHashMapMethod() {
        ConcurrentHashMap<String, String> map = new ConcurrentHashMap<>();
    }

}
