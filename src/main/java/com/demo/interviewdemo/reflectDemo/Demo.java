package com.demo.interviewdemo.reflectDemo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Description:
 * @Author: jiahuiyang
 * @Date: Created in 12:49 2020/4/5
 */
public class Demo {

    public static void main(String[] args) throws Exception {

//        method();
        method2();
    }

    /**
     * 循环获取反射变量值 查看对应变量值是否变化(是)
     */
    public static void method() throws Exception {

        Count count = new Count();
        for (int i = 0; i < 5; i++) {
            Field field = count.getClass().getDeclaredField("modCount");
            field.setAccessible(true);
            System.out.println(field.get(count));
            count.setIncrModCount();
        }

    }

    static class Count{
        private int modCount = 0;

        public void setIncrModCount() {
            modCount++;
        }

        public int getModCount() {
            return modCount;
        }
    }

    /**
     * 反射获取父类的属性和方法
     */
    public static Field[] getAllField(Class clazz) {
        List<Field> list = new ArrayList<>();
        while (clazz != null) {
            Field[] fields = clazz.getDeclaredFields();
            list.addAll(new ArrayList<>(Arrays.asList(fields)));
            clazz = clazz.getSuperclass();
        }
        // 设置固定大小的数组 避免空间浪费
        Field[] fields = new Field[list.size()];
        return list.toArray(fields);
    }

    public static void method2() {
        Arrays.asList(getAllField(SubCount.class)).stream().forEach( v->{
            System.out.println(v.getName());
        });
    }

    static class SubCount extends Count{
        private int id;
        private int name;
    }
}
