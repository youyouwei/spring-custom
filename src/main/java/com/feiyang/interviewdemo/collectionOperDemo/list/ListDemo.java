package com.feiyang.interviewdemo.collectionOperDemo.list;

import com.feiyang.interviewdemo.springELDemo.Item;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @description:
 * List 元素是有序的、可重复。
 * List 接口中常用类
 * Vector：线程安全，但速度慢，已被 ArrayList 替代。底层数据结构是数组
 * ArrayList：线程不安全，查询速度快。底层数据结构是数组
 * LinkedList：线程不安全。增删速度快。底层数据结构是链表
 * @author: jhyang
 * @create: 2019-07-02 13:36
 **/
public class ListDemo {
    public static void main(String[] args) {

        //array2List();

        //removeListElement();
        arrayOrCollectionSort();
    }


    /**
     * list集合转array
     */
    public static void list2Array() {
        List<String> list = new ArrayList<>(2);
        list.add("guan");
        list.add("xin");
        String[] array = new String[list.size()];
        array = list.toArray(array);

        //array = (String[]) list.toArray();  //直接使用toArray无参方法存在问题 此方法返回值只能是Object[]，若强转其它类型数组将出现ClassCastException

        for (String s : array) {
            System.out.println(s);
        }

    }

    /**
     * 使用工具类 Arrays.asList()把数组转换成集合时，不能使用其修改集合相关的方
     * 法，它的 add/remove/clear 方法会抛出 UnsupportedOperationException 异常。
     */
    public static void array2List() {
        String[] str = new String[]{"you", "wu"};
        List list = Arrays.asList(str);
        //list.add("ss");  不能修改
        list.forEach(System.out::println);
        str[0] = "we";  //修改数组中内容会 list中的内容随之修改
        list.forEach(System.out::println);
    }

    /**
     * 删除list中的某个元素 不能使用foreach遍历查找删除
     */
    public static void removeListElement() {
        List<String> list = new ArrayList<>();
        list.add("1");
        list.add("2");
        Iterator<String> iterator = list.iterator();
        while (iterator.hasNext()) {
            String item = iterator.next();
            if (item.equals("2")) {
                iterator.remove();
            }
        }

        //for修改报错异常
        /*for (String s : list) {
            if ("2".equals(s)) {
                list.remove(s);
            }
        }*/

        list.forEach(System.out::println);

    }

    /**
     * 数组或则集合排序
     */
    public static void arrayOrCollectionSort() {
        List<String> list = new ArrayList<>();
        list.add("123");
        list.add("12e");
        list.add("sd");
        list.add("jawe");
        Collections.sort(list);
        list.forEach(System.out::println);

        Collections.sort(list,  (u,v)->{
            return v.compareTo(u);
        });    //自定义Comparator排序方法 compare  该排序为倒序

        list.forEach(System.out::println);

    }

}
