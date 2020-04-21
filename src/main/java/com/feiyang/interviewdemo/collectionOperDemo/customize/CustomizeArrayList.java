package com.feiyang.interviewdemo.collectionOperDemo.customize;

/**
 * @Description:
 * @Author: jiahuiyang
 * @Date: Created in 20:04 2020/4/20
 */
public class CustomizeArrayList<E> {
    /**
     * 存放元素的数组
     */
    private Object[] table;

    public CustomizeArrayList() {

    }

    /**
     * 添加元素
     * @param e
     * @return
     */
    public boolean add(E e) {


        return true;
    }

    /**
     * 扩容
     */
    private void resize() {

    }


}
