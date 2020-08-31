package com.feiyang.interviewdemo.collectionOperDemo.hash;

import org.springframework.util.CollectionUtils;

import java.util.*;

/**
 * @Description: HashMap 初始化方案
 * @Author: jiahuiyang
 * @Date: Created in 14:47 2020/8/31
 */
public class HashMapInitializeDemo {

    /**
     * HashMap初始化 使用匿名内部类的方式
     */
    public static void initialize() {
        HashMap<String,Integer> map = new HashMap<String,Integer>(){{put("a",1);put("b",2);put("c",3);}};
    }


    static class Num{

        public Num() {

            System.out.println("initialize num");
        }

        void put() {
            System.out.println("put something");

        }
    }

    public static void main(String[] args) {
        //这是匿名内部类的写法，第一个大括号是代表类，第二个大括号代表匿名内部类的初始化代码块。 这种语法表示该匿名内部类继承了Num类，还有我们经常使用匿名内部类来作为接口的实现类，作为方法入参。

        // 1.匿名内部类不能是抽象类，因为系统在创建匿名内部类时，会立即创建匿名内部类的对象，因此不允许将匿名内部类定义为抽象类。

        // 2.匿名内部类不能定义构造器（Constructor），由于匿名内部类没有类名，所以无法定义构造器，但匿名构造类可以定义初始化块，可以通过实例初始化块来完成构造函数需要完成的部分。
        Num num = new Num(){{
            put();}};

        Num num1 = new Num() {{
            System.out.println("create num");
        }};

        List<String> list = new LinkedList<String>(){{add("a");add("b");}};
        System.out.println(list.get(0));

        List<String> list1 = new LinkedListAnonymity<>();
        System.out.println(list1.get(0));

        // 创建不可变集合
        Map<String, Integer> map = Collections.unmodifiableMap(new HashMap<String, Integer>() {{
            put("a", 1);
            put("b", 2);
            put("c", 3);
        }});

        Map<String, Integer> map1 = Collections.unmodifiableMap(new HashMap<String, Integer>() {{
            put("a", 1);
            put("b", 2);
            put("c", 3);
        }});
        //进行put操作时会抛出异常
        map.put("d", 4);



    }

    /**
     * LinkedListAnonymity
     * new LinkedListAnonymity<>(); 等同于HashMapInitializeDemo中的匿名类  List<String> list = new LinkedList<String>(){{add("a");add("b");}};
     * @param <T>
     */
    static class LinkedListAnonymity<T> extends LinkedList<T> {
        public LinkedListAnonymity() {
            add((T) "a");
            add((T) "b");
        }
    }

}
