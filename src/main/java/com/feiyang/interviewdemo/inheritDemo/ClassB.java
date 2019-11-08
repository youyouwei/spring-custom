package com.feiyang.interviewdemo.inheritDemo;

/**
 * @Description:
 * @Author: jiahuiyang
 * @Date: Created in 14:28 2019/10/28
 */
public class ClassB extends ClassA {

    /**
     * 如果构造方法中没有执行 父类中的构造方法 就是默认执行父类无参构造方法
     * @param name
     */
    public ClassB(String name) {
        System.out.println("structure ClassB" + name);
    }

}
