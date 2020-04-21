package com.feiyang.interviewdemo.collectionOperDemo;

import java.util.*;

/**
 * @Description: Iterator顺序遍历 和 Spliterator并行遍历
 * @Author: jiahuiyang
 * @Date: Created in 12:04 2020/4/17
 */
public class IteratorDemo {

    private static final List<Integer> LIST = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 6, 7, 8));

    public static void main(String[] args) {
        iteratorOper();

        System.out.println("Spliterator 遍历器: ");
        spliteratorOper();

    }

    /**
     * iterator顺序遍历器
     */
    public static void iteratorOper() {
        Iterator iterator = LIST.iterator();

        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }

    }

    /**
     * Spliterator 并行遍历器
     */
    public static void spliteratorOper() {
        Spliterator firstSpliterator = LIST.spliterator();
        Spliterator secondSpliterator = firstSpliterator.trySplit();
        Spliterator thirdSpliterator = firstSpliterator.trySplit();

        // 调试结果是每个Spliterator会遍历出不同的元素
        System.out.println("firstSpliterator: ");
        while (firstSpliterator.tryAdvance(System.out::println)) {

        }

        System.out.println("secondSpliterator: ");
        while (secondSpliterator.tryAdvance(System.out::println)) {

        }

        System.out.println("thirdSpliterator: ");
        while (thirdSpliterator.tryAdvance(System.out::println)) {

        }
    }


}
