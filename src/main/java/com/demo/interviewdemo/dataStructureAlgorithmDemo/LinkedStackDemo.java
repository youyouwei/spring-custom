package com.demo.interviewdemo.dataStructureAlgorithmDemo;

import java.util.LinkedList;

/**
 * @Description: 自定义栈数据结构
 * 也是通过LinkedList来实现 比较简单 当然也可以通过数组来实现
 * @Author: jiahuiyang
 * @Date: Created in 15:55 2020/8/24
 */
public class LinkedStackDemo {

    private LinkedList<String> items = new LinkedList<>();

    public LinkedStackDemo() {

    }


    public static void main(String[] args) {
        //自顶向下编程法 先定义该类需要进行的操作 然后再实现 这样会避免功能点的遗漏

        LinkedStackDemo stackDemo = new LinkedStackDemo();
        stackDemo.push("tom");
        stackDemo.push("tom1");
        stackDemo.push("tom2");
        System.out.println(stackDemo.pop());

        stackDemo.clear();

        System.out.println(stackDemo.pop());

    }

    /**
     * 清空栈
     */
    private void clear() {
        if (items.size() > 0) {
            items.clear();
        }
    }

    /**
     * 入栈
     * @param element
     */
    private void push(String element) {
        items.push(element);

    }

    /**
     * 出栈
     * @return
     */
    private String pop() {
        if (items.size() > 0) {
            return items.pop();
        }
        return null;
    }

}
