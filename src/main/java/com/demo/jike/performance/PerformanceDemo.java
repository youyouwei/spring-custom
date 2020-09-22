package com.demo.jike.performance;

import java.util.Iterator;
import java.util.List;

/**
 * @Description:
 * @Author: jiahuiyang
 * @Date: Created in 17:16 2019/12/13
 */
public class PerformanceDemo {
    public static void main(String[] args) {

        Circulation.circulationNest();

        List<Integer> list = null;
        // 编译器会把for 转化成对迭代器iterator的使用 并且list不能为空
        for (Integer i : list) {
            System.out.println(i);
        }

        Iterator iterator = list.iterator();
        while (iterator.hasNext()) {
            Integer num = (Integer) iterator.next();
            iterator.remove();//iterator可以删除元素  不能修改
            iterator.forEachRemaining(System.out::println);
            System.out.println(num);
        }






    }
}
