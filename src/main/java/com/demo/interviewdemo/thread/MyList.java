package com.demo.interviewdemo.thread;

import java.util.ArrayList;
import java.util.List;

/**
 * @description:
 * @author: jhyang
 * @create: 2019-04-02 17:50
 **/
public class MyList {
    private static List<String> list = new ArrayList<>();

    public static void add() {
        list.add("anyString");
    }

    public static int size() {
        return list.size();
    }

}
