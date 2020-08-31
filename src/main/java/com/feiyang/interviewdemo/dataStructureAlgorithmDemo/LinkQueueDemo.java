package com.feiyang.interviewdemo.dataStructureAlgorithmDemo;

import java.util.LinkedList;

/**
 * @Description: 基于链表实现队列
 * 可以自定义Node节点实现双向链表来实现队列 或则直接通过LinkedList来实现队列
 * 链表队列由于链表的特性没有长度限制
 *
 * @Author: jiahuiyang
 * @Date: Created in 15:13 2020/8/24
 */
public class LinkQueueDemo {

    private LinkedList<String> items = new LinkedList<>();

    public LinkQueueDemo() {

    }

    /**
     * 现在使用的基本上都是双向链表 双向链表可以降低向前遍历的时间复杂度
     */
    private static class Node {
        Node prev;
        Node next;
        Object element;

        public Node(Node prev, Node next, Object element) {
            this.prev = prev;
            this.next = next;
            this.element = element;
        }
    }

    public static void main(String[] args) {
        //自顶向下编程 队列可以实现的操作
        LinkQueueDemo queue = new LinkQueueDemo();
        queue.enqueue("tom");
        queue.enqueue("tom1");
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
    }

    /**
     * 取队列
     * @return
     */
    private String dequeue() {
        if (items.size() > 0) {
            return items.removeLast();
        }
        return null;
    }

    /**
     * 插入队列 直接使用LinkedList 的 addFirst方式头插入队列
     * @param element
     * @return
     */
    private boolean enqueue(String element) {
        items.addFirst(element);
        return true;
    }

}


