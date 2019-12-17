package com.feiyang.jike.dataStructuresAndAlgorithms.sorts;

import java.util.Arrays;
import java.util.List;

/**
 * @Description: 排序接口
 * @Author: jiahuiyang
 * @Date: Created in 15:22 2019/12/17
 */
public interface SortAlgorithm {
    /**
     * 主要的排序方法
     * @param unsorted
     * @param <T>
     * @return
     */
    <T extends Comparable<T>> T[] sort(T[] unsorted);

    /**
     * list 转数组的排序方法 排序算法只能通过数组来实现 因为数组有通过下标随机访问的属性 链表不适合排序
     * @param unsorted
     * @param <T>
     * @return
     */
    default <T extends Comparable<T>> List<T> sort(List<T> unsorted) {
        //转换成 数组 T[]
        return Arrays.asList(sort(unsorted.toArray((T[]) new Comparable[unsorted.size()])));
    }

}
