package com.feiyang.interviewdemo.collectionOperDemo.customize;

/**
 * @Description:
 * @Author: jiahuiyang
 * @Date: Created in 19:41 2020/4/20
 */
public class CustomizeLinkedList<T> {

    private Node<T> head;
    private Node<T> last;


    public CustomizeLinkedList() {

    }

    public boolean add(T t) {

        final Node<T> l = last;
        final Node<T> newNode = new Node<>(t, l, null);
        last = newNode;
        if (l == null) {
            head = newNode;
        } else {
            l.next = newNode;
        }
        return true;

    }



    /**
     * 链表节点 双向节点
     * 双向链表方便头尾插入和查找 单向需要一直找到尾才能操作尾部元素
     * @param <T>
     */
    static class Node<T> {
        T t;
        Node<T> next;
        Node<T> prev;

        public Node(T t, Node<T> prev, Node<T> next) {
            this.t = t;
            this.prev = prev;
            this.next = next;
        }
    }

    /**
     * 链表节点 单向节点
     * @param <T>
     */
    static class SingleNode<T> {
        T t;
        SingleNode<T> next;

        public SingleNode(T t, SingleNode<T> next) {
            this.t = t;
            this.next = next;
        }

    }


}

