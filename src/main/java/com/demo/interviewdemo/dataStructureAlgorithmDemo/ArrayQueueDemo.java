package com.demo.interviewdemo.dataStructureAlgorithmDemo;

/**
 * @Description: 使用数组实现队列
 * 记录数组中队列的head和tail下标位置，然后新增队列元素是从数组元素一直向后插入，取的时候是从head所在位置取，其实存区主要是根据head和tail的移动实现的。但是在数组中的操作依次是向后的。
 * @Author: jiahuiyang
 * @Date: Created in 10:23 2020/8/24
 */
public class ArrayQueueDemo {
    /**
     * 底层使用数组来存储队列数据
     */
    private String[] items;

    /**
     * 数组长度
     */
    private int length = 0;

    /**
     * 队列头数组指针位置
     */
    private int head = 0;

    /**
     * 队列尾数组指针位置
     */
    private int tail = 0;

    public ArrayQueueDemo(int capacity) {
        items = new String[capacity];
        length = capacity;
    }

    /**
     * 入队
     * @param item
     * @return
     */
    public boolean enqueue(String item) {
        //队列已满
        if (tail == length) {
            if (head == 0) {
                return false;
            }
            //如果是head不为0 并且队列已满 就需要向前移动
            for (int i = head; i < tail; i++) {
                items[i - head] = items[i];
            }
            tail -= head;
            head = 0;
        }

        items[tail] = item;
        ++tail;
        return true;

    }

    /**
     * 出队
     * @return
     */
    public String dequeue() {
        //队列为空
        if (head == tail) {
            return null;
        }
        String ret = items[head];
        ++head;
        return ret;
    }

    public static void main(String[] args) {
        ArrayQueueDemo queue = new ArrayQueueDemo(10);
        queue.enqueue("tim");
        queue.enqueue("tom");

        System.out.println(queue.dequeue());
    }


}
