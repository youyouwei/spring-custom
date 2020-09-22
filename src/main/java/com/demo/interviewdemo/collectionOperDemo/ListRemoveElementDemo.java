package com.demo.interviewdemo.collectionOperDemo;

import java.util.*;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @description:
 * list 删除元素的方式
 * @author: jhyang
 * @create: 2019-06-25 10:12
 **/
public class ListRemoveElementDemo {

    static List<String> list = new ArrayList<>();

    static {
        list.add("aa");
        list.add("bb");
        list.add("cc");
    }

    public static void main(String[] args) {

        Integer a = 1;
        Integer b = 2;
        boolean isTrue = Objects.equals(a, b);
        boolean isDeepTrue = Objects.deepEquals(a, b);
        System.out.println(isTrue);
        System.out.println(isDeepTrue);

        int compareResult = Objects.compare(a, b, (v1, v2) -> {
            return v1.compareTo(v2);
        });

        System.out.println(compareResult);

        Name<String> name = new Name<>();
        String nameStr = name.getName("tom");
        System.out.println(nameStr);

        Name<SetDemo> name1 = new Name<>();
        String nameStr1 = name1.getName(new SetDemo());
        System.out.println(nameStr1);


        List<String> list = Collections.synchronizedList(Arrays.asList("1", "2", "3"));
        list.get(1);

        Vector<String> vector = new Vector<>();

        //可重入锁
        Lock lock = new ReentrantLock();

        lock.lock();

        lock.unlock();


    }

    /**
     * 使用Iterator的remove()方法
     * 不能在for 或则foreach遍历时删除（遍历时不能修改集合元素）
     */
    public static void removeByIterator() {

        Iterator<String> it = list.iterator();
        while (it.hasNext()) {
            String str = it.next();
            if ("aa".equals(str)) {
                it.remove();
            }
        }


    }

    static class Name<T>{
        public String getName(T t) {
            if (t instanceof String) {
                return t+"---";
            }
            return t.toString();
        }
    }


}
