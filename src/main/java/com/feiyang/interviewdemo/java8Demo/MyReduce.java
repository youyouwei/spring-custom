package com.feiyang.interviewdemo.java8Demo;

import org.springframework.util.CollectionUtils;

import java.util.List;

/**
 * @Description: 实现reduce 函数式接口
 * @Author: jiahuiyang
 * @Date: Created in 16:10 2020/5/20
 */
@FunctionalInterface
public interface MyReduce<T> {
    /**
     * 函数接口匿名类实现的方法
     * 单独对象做处理
     *
     * @param t1
     * @param t2
     * @return
     */
    T operate(T t1, T t2);

    /**
     * 集合具体实现
     * @param reduce
     * @param list
     * @param <E>
     * @return
     */
    static <E> E reduce(MyReduce<E> reduce, List<E> list) {
        if (reduce == null|| CollectionUtils.isEmpty(list)) {
            return null;
        }
        if (list.size() == 1) {
            return list.get(0);
        }

        E result = list.get(0);
        for (int i = 1; i < list.size(); i++) {
//            reduce 汇聚就是上一个参数和下一个参数放在operate 方法中做处理 得到一个最终结果
            result = reduce.operate(result, list.get(i));
        }
        return null;
    }



}
