package com.demo.interviewdemo.syntacticSugarDemo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @Description:
 * @Author: jiahuiyang
 * @Date: Created in 16:54 2020/11/12
 */
public class Demo<T>{

    private Object lock;

    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("a");
        list.add("b");
        list.add("c");

        for (String s : list) {
            System.out.println(s);
        }

        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }

        HashMap hashMap = new HashMap();

        hashMap.entrySet();

        String str = new String("ss").intern();
    }

    public void method() {
        synchronized (lock) {
            System.out.println("get lock success!");
        }

    }

    public void method2() {
        T t = (T) new Object();

        System.out.println(t);

    }

}
