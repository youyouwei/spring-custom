package com.demo.interviewdemo.collectionOperDemo.list;

import java.util.LinkedList;
import java.util.List;

/**
 * @Description: linkList 是Node 结构对象连接成的一个双向链表
 * @Author: jiahuiyang
 * @Date: Created in 13:07 2019/11/8
 */
public class LinkListDemo<E> {

    public static void main(String[] args) {
        List<String> list = new LinkedList<>();


    }

    transient int size = 0;
    transient Node<E> first;
    transient Node<E> last;

    public boolean add(E e) {
        linkLast(e);
        return true;
    }

    /**
     * Links e as last element.
     */
    void linkLast(E e) {
        final LinkListDemo.Node<E> l = last;
        final LinkListDemo.Node<E> newNode = new LinkListDemo.Node<>(l, e, null);
        last = newNode;
        if (l == null){
            first = newNode;
        } else{
            l.next = newNode;
        }
        size++;
//        modCount++;
    }


    private static class Node<E> {
        E item;
        Node<E> next;
        Node<E> prev;

        Node(Node<E> prev, E element, Node<E> next) {
            this.item = element;
            this.prev = prev;
            this.next = next;
        }
    }


}

